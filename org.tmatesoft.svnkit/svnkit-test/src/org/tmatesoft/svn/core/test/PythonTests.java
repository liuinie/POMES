/*
 * ====================================================================
 * Copyright (c) 2004-2007 TMate Software Ltd.  All rights reserved.
 *
 * This software is licensed as described in the file COPYING, which
 * you should have received as part of this distribution.  The terms
 * are also available at http://svnkit.com/license.html
 * If newer versions of this license are posted there, you may use a
 * newer version instead, at your option.
 * ====================================================================
 */

package org.tmatesoft.svn.core.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.tmatesoft.svn.util.SVNDebugLog;

/**
 * @version 1.1.1
 * @author  TMate Software Ltd.
 */
public class PythonTests {

	private static File ourPropertiesFile;
    private static Process ourSVNServer;
    
    private static AbstractPythonTestLogger[] ourLoggers; 

    public static void main(String[] args) {
		String fileName = args[0];
		ourPropertiesFile = new File(fileName);
        ourLoggers = new AbstractPythonTestLogger[] {new ConsoleLogger(), new XMLLogger()};

		Properties properties = null;
		String defaultTestSuite = null;
		try {
			properties = loadProperties(ourPropertiesFile);
			defaultTestSuite = loadDefaultTestSuite();
		} catch (IOException e) {
			System.out.println("can't load properties, exiting");
			System.exit(1);
		}
        
        for (int i = 0; i < ourLoggers.length; i++) {
            try{
                ourLoggers[i].startTests(properties);
            }catch(IOException ioe){
                ioe.getMessage();
                ioe.printStackTrace();
                System.exit(1);
            }
        }

        String pythonTestsRoot = properties.getProperty("python.tests");
		properties.setProperty("repository.root", new File(pythonTestsRoot).getAbsolutePath());
        String absTestsRootLocation = new File(pythonTestsRoot).getAbsolutePath().replace(File.separatorChar, '/');
        if(!absTestsRootLocation.startsWith("/")){
            absTestsRootLocation = "/" + absTestsRootLocation; 
        }
        String url = "file://" + absTestsRootLocation;
        if (Boolean.TRUE.toString().equals(properties.getProperty("python.file"))) {
            boolean started = false;
            try {
                for (int i = 0; i < ourLoggers.length; i++) {
                    ourLoggers[i].startServer("file", url);
                }
                started = true;
                runPythonTests(properties, defaultTestSuite, url);
            } catch (Throwable th) {
                th.printStackTrace();
            } finally {
                if (started) {
                    for (int i = 0; i < ourLoggers.length; i++) {
                        ourLoggers[i].endServer("file", url);
                    }
                }
            }
        }

        url = "svn://localhost";
        if (Boolean.TRUE.toString().equals(properties.getProperty("python.svn"))) {
            boolean started = false;
			try {
				int port = startSVNServe(properties);
                url += ":" + port;
                for (int i = 0; i < ourLoggers.length; i++) {
                    ourLoggers[i].startServer("svnserve", url);
                }
                started = true;
				runPythonTests(properties, defaultTestSuite, url);
			} catch (Throwable th) {
				th.printStackTrace();
			} finally {
				stopSVNServe();
                if (started) {
                    for (int i = 0; i < ourLoggers.length; i++) {
                        ourLoggers[i].endServer("svnserve", url);
                    }
                }
			}
		}

		if (Boolean.TRUE.toString().equals(properties.getProperty("python.http"))) {
			properties.setProperty("apache.conf", "apache/python.template.conf");
            boolean started = false;
            int port = -1;
			try {
				port = startApache(properties);
                url = "http://localhost:" + port;
			    for (int i = 0; i < ourLoggers.length; i++) {
                    ourLoggers[i].startServer("apache", url);
                }
                started = true;
				runPythonTests(properties, defaultTestSuite, url);
			} catch (Throwable th) {
				th.printStackTrace();
			} finally {
				try {
					stopApache(properties, port);
                    if (started) {
                        for (int i = 0; i < ourLoggers.length; i++) {
                            ourLoggers[i].endServer("apache", url);
                        }
                    }
                } catch (Throwable th) {
					th.printStackTrace();
				}
			}
		}
        for (int i = 0; i < ourLoggers.length; i++) {
            ourLoggers[i].endTests(properties);
        }
	}

	private static void runPythonTests(Properties properties, String defaultTestSuite, String url) throws IOException {
		System.out.println("RUNNING TESTS AGAINST '" + url + "'");
		String pythonLauncher = properties.getProperty("python.launcher");
		String testSuite = properties.getProperty("python.tests.suite", defaultTestSuite);
		String options = properties.getProperty("python.tests.options", "");
		for (StringTokenizer tests = new StringTokenizer(testSuite, ","); tests.hasMoreTokens();) {
			final String testFileString = tests.nextToken();
			List tokens = tokenizeTestFileString(testFileString);

            String suiteName = (String) tokens.get(0);
			for (int i = 0; i < ourLoggers.length; i++) {
                ourLoggers[i].startSuite(suiteName);
            }
			
			final String testFile = suiteName + "_tests.py";
			tokens = tokens.subList(1, tokens.size());

		    final List availabledTestCases = getAvailableTestCases(pythonLauncher, testFile);
			final List testCases = !tokens.isEmpty() ? combineTestCases(tokens, availabledTestCases) : availabledTestCases;

			System.out.println("PROCESSING " + testFile + " " + testCases);
			for (Iterator it = testCases.iterator(); it.hasNext();) {
				final Integer testCase = (Integer)it.next();
				processTestCase(pythonLauncher, testFile, options, String.valueOf(testCase), url);
			}
            for (int i = 0; i < ourLoggers.length; i++) {
                ourLoggers[i].endSuite(suiteName);
            }
		}
	}

	private static void processTestCase(String pythonLauncher, String testFile, String options, String testCase, String url) {
	    Collection commandsList = new ArrayList();
        commandsList.add(pythonLauncher);
        commandsList.add(testFile);
        commandsList.add("--v");
        commandsList.add("--url=" + url);
        if (options != null && !"".equals(options.trim())) {
            commandsList.add(options);
        }
        commandsList.add(String.valueOf(testCase));
        String[] commands = (String[]) commandsList.toArray(new String[commandsList.size()]); 

		try {
			Process process = Runtime.getRuntime().exec(commands, null, new File("python/cmdline"));
			new ReaderThread(process.getInputStream(), null).start();
			new ReaderThread(process.getErrorStream(), null).start();
			try {
				process.waitFor();
			}
			catch (InterruptedException e) {
			}
		}
		catch (Throwable th) {
			System.err.println("ERROR: " + th.getMessage());
			th.printStackTrace(System.err);
		}
	}

	private static List tokenizeTestFileString(String testFileString) {
		final StringTokenizer tokenizer = new StringTokenizer(testFileString, " ", false);
		final List tokens = new ArrayList();
		while (tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
			continue;
		}

		return tokens;
	}

	private static List combineTestCases(List tokens, List availableTestCases) {
		final List combinedTestCases = new ArrayList();
		for (Iterator it = tokens.iterator(); it.hasNext();) {
			final String token = (String)it.next();
			if (token.equalsIgnoreCase("all")) {
				combinedTestCases.addAll(availableTestCases);
				continue;
			}

            if (token.indexOf("-") > 0) {
                // parse range
                String startNumber = token.substring(0, token.indexOf("-"));
                String endNumber = token.substring(token.indexOf("-") + 1);
                try {
                    int start = Integer.parseInt(startNumber);
                    int end = Integer.parseInt(endNumber);
                    if (start > end) {
                        int i = start;
                        start = end;
                        end = i;
                    }
                    for(int i = start; i <= end; i++) {
                        if (availableTestCases.contains(new Integer(i))) {
                            combinedTestCases.add(new Integer(i));
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
                continue;
            }
			final Integer testCase;
			try {
				testCase = new Integer(token);
			} catch (NumberFormatException ex) {
				System.err.println("ERROR: " + ex.getMessage());
				ex.printStackTrace(System.err);
				continue;
			}

			if (testCase.intValue() < 0) {
				combinedTestCases.remove(new Integer(-testCase.intValue()));
			} else if (availableTestCases.contains(testCase)) {
                combinedTestCases.add(testCase);
			}
		}

		return combinedTestCases;
	}

	private static List getAvailableTestCases(String pythonLauncher, String testFile) throws IOException {
		final String[] commands = new String[]{pythonLauncher, testFile, "list"};
		final ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			Process process = Runtime.getRuntime().exec(commands, null, new File("python/cmdline"));
            Thread readerThread = new ReaderThread(process.getInputStream(), new PrintStream(os));
            readerThread.start();
			new ReaderThread(process.getErrorStream(), null).start();
			try {
				process.waitFor();
                readerThread.join(5000);                
			}
			catch (InterruptedException e) {
			}
            os.close();
		}
		catch (Throwable th) {
			System.err.println("ERROR: " + th.getMessage());
			th.printStackTrace(System.err);
		}

		final String listString = new String(os.toByteArray());
		final BufferedReader reader = new BufferedReader(new StringReader(listString));
		final List tests = new ArrayList();
		String line;
		while ((line = reader.readLine()) != null) {
			final StringTokenizer tokenizer = new StringTokenizer(line, " \t", false);
			if (!tokenizer.hasMoreTokens()) {
				continue;
			}

			final String first = tokenizer.nextToken();
			if (first.startsWith("Test") || first.startsWith("---")) {
				continue;
			}

			if (tokenizer.hasMoreTokens()) {
				final String hint = tokenizer.nextToken().trim();
				if (hint.equalsIgnoreCase("SKIP") || hint.equalsIgnoreCase("XFAIL")) {
					continue;
				}
			}

			try {
				tests.add(new Integer(first));
			}
			catch (NumberFormatException ex) {
				System.err.println("ERROR: " + ex.getMessage());
				ex.printStackTrace(System.err);
			}
		}
		return tests;
	}

	static class ReaderThread extends Thread {

		private final BufferedReader myInputStream;
		private final PrintStream myHelpStream;

		public ReaderThread(InputStream is, PrintStream helpStream) {
			myInputStream = new BufferedReader(new InputStreamReader(is));
			myHelpStream = helpStream;
			setDaemon(false);
		}

		public void run() {
		    try {
				String line;
				while ((line = myInputStream.readLine()) != null) {
                    PythonTestResult testResult = PythonTestResult.parse(line);
                    SVNDebugLog.getDefaultLog().info(line);
                    if (testResult != null) {
                        for (int i = 0; i < ourLoggers.length; i++) {
                            ourLoggers[i].handleTest(testResult);
                        }
                    }
					if (myHelpStream != null) {
						myHelpStream.println(line);
						myHelpStream.flush();
					}
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String loadDefaultTestSuite() throws IOException {
		final File file = new File("python-suite.txt");
		final BufferedReader reader = new BufferedReader(new FileReader(file));
		final StringBuffer defaultTestSuite = new StringBuffer();
		try {
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				if (defaultTestSuite.length() > 0) {
					defaultTestSuite.append(",");
				}

				defaultTestSuite.append(line.trim());
			}
		}
		finally {
			reader.close();
		}

		return defaultTestSuite.toString();
	}
    
    public static Properties loadProperties(File file) throws IOException {
        FileInputStream is = new FileInputStream(file);
        Properties props = new Properties();
        props.load(is);
        is.close();
        return props;
    }
    
    public static int startSVNServe(Properties props) throws Throwable {
        String path = getRepositoryRoot(props);
        
        int portNumber = 3690;
        try {
            portNumber = Integer.parseInt(props.getProperty("svn.port", "3690"));
        } catch (NumberFormatException nfe) {
        }
        portNumber = findUnoccupiedPort(portNumber);
        
        String svnserve = props.getProperty("svnserve.path");
        String[] command = {svnserve, "-d", "--foreground", "--listen-port", portNumber + "", "-r", path};
        ourSVNServer = execCommand(command, false);
        return portNumber;
    }
    
    public static void stopSVNServe() {
        if (ourSVNServer != null) {
            ourSVNServer.destroy();
        }
    }

    public static int startApache(Properties props) throws Throwable {
        return apache(props, -1, true);
    }

    public static void stopApache(Properties props, int port) throws Throwable {
        apache(props, port, false);
    }
    
    private static int apache(Properties props, int port, boolean start) throws Throwable {
        String[] command = null;
        File configFile = File.createTempFile("jsvn.", ".apache.config.tmp");
        configFile.deleteOnExit();
        String path = configFile.getAbsolutePath().replace(File.separatorChar, '/');
        port = generateApacheConfig(configFile, props, port);

        String apache = props.getProperty("apache.path");
        command = new String[] {apache, "-f", path, "-k", (start ? "start" : "stop")};
        execCommand(command, start);
        return port;
    }
    
    private static int generateApacheConfig(File destination, Properties props, int port) throws IOException {
        File template = new File(props.getProperty("apache.conf", "apache/httpd.template.conf"));
        byte[] contents = new byte[(int) template.length()];
        InputStream is = new FileInputStream(template);
        is.read(contents);
        is.close();
        
        File passwdFile = new File("apache/passwd");
        
        if (port < 0) {
            port = 8082;
            try {
                port = Integer.parseInt(props.getProperty("apache.port", "8082"));
            } catch (NumberFormatException nfe) {
            }
            port = findUnoccupiedPort(port);
        }
        
        String config = new String(contents);
        config = config.replaceAll("%root%", props.getProperty("apache.root"));
        config = config.replaceAll("%port%", port + "");
        String path = getRepositoryRoot(props);
        config = config.replaceAll("%repository.root%", path);
        config = config.replaceAll("%passwd%", passwdFile.getAbsolutePath().replace(File.separatorChar, '/'));
        config = config.replaceAll("%home%", System.getProperty("user.home").replace(File.separatorChar, '/'));
        
        String pythonTests = new File(props.getProperty("python.tests")).getAbsolutePath().replace(File.separatorChar, '/');
        config = config.replaceAll("%python.tests%", pythonTests);
        
        FileOutputStream os = new FileOutputStream(destination);
        os.write(config.getBytes());
        os.close();
        return port;
    }
    
    private static int findUnoccupiedPort(int port) {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket();
            socket.bind(null);
            return socket.getLocalPort();
        } catch (IOException e) {
            return port;
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private static String getRepositoryRoot(Properties props) {
        String path = props.getProperty("repository.root");
        path = path.replaceAll("%home%", System.getProperty("user.home").replace(File.separatorChar, '/'));
        path = path.replace(File.separatorChar, '/');
        new File(path).mkdirs();
        return path;
    }
    
    private static Process execCommand(String[] command, boolean wait) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        if (process != null) {
            try {
                new ReaderThread(process.getInputStream(), null).start();
                new ReaderThread(process.getErrorStream(), null).start();
                if (wait) {
                    int code = process.waitFor();
                    if (code != 0) {
                        StringBuffer commandLine = new StringBuffer();
                        for (int i = 0; i < command.length; i++) {
                            commandLine.append(command[i]);
                            if (i + 1 != command.length) {
                                commandLine.append(' ');
                            }
                        }
                        throw new IOException("process '"  +  commandLine + "' exit code is not 0 : " + code);
                    }
                }
            } catch (InterruptedException e) {
                throw new IOException("interrupted");
            }
        }
        return process;
    }
    
}
