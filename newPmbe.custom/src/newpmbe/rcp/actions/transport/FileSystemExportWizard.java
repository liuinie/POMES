package newpmbe.rcp.actions.transport;

import java.util.List;

import newpmbe.rcp.NewPmbePlugin;

import org.eclipse.core.resources.IResource;
//import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
//import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
//import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
//import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;
//import org.eclipse.ui.internal.wizards.datatransfer.WizardFileSystemResourceExportPage1;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Standard workbench wizard for exporting resources from the workspace
 * to the local file system.
 * <p>
 * This class may be instantiated and used without further configuration;
 * this class is not intended to be subclassed.
 * </p>
 * <p>
 * Example:
 * <pre>
 * IWizard wizard = new FileSystemExportWizard();
 * wizard.init(workbench, selection);
 * WizardDialog dialog = new WizardDialog(shell, wizard);
 * dialog.open();
 * </pre>
 * During the call to <code>open</code>, the wizard dialog is presented to the
 * user. When the user hits Finish, the user-selected workspace resources 
 * are exported to the user-specified location in the local file system,
 * the dialog closes, and the call to <code>open</code> returns.
 * </p>
 */
public class FileSystemExportWizard extends Wizard implements IExportWizard {
    private IStructuredSelection selection;

    private WizardFileSystemResourceExportPage1 mainPage;

    /**
     * Creates a wizard for exporting workspace resources to the local file system.
     */
    public FileSystemExportWizard() {
    	AbstractUIPlugin plugin = NewPmbePlugin.getDefault();
        IDialogSettings workbenchSettings = plugin.getDialogSettings();
        IDialogSettings section = workbenchSettings
                .getSection("FileSystemExportWizard");//$NON-NLS-1$
        if (section == null) {
			section = workbenchSettings.addNewSection("FileSystemExportWizard");//$NON-NLS-1$
		}
        setDialogSettings(section);
    }

    /* (non-Javadoc)
     * Method declared on IWizard.
     */
    public void addPages() {
        super.addPages();
        mainPage = new WizardFileSystemResourceExportPage1(selection);
        addPage(mainPage);
    }


    /* (non-Javadoc)
     * Method declared on IWorkbenchWizard.
     */
    public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
        this.selection = currentSelection;
        List selectedResources = IDE.computeSelectedResources(currentSelection);
        if (!selectedResources.isEmpty()) {
            this.selection = new StructuredSelection(selectedResources);
        }

        // look it up if current selection (after resource adapting) is empty
        if (selection.isEmpty() && workbench.getActiveWorkbenchWindow() != null) {
            IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
                    .getActivePage();
            if (page != null) {
                IEditorPart currentEditor = page.getActiveEditor();
                if (currentEditor != null) {
                    Object selectedResource = currentEditor.getEditorInput()
                            .getAdapter(IResource.class);
                    if (selectedResource != null) {
                        selection = new StructuredSelection(selectedResource);
                    }
                }
            }
        }

        setWindowTitle("����");
        setDefaultPageImageDescriptor(NewPmbePlugin.getImageDescriptor("icons/transport/export_wiz(2).gif"));//$NON-NLS-1$
        setNeedsProgressMonitor(true);
    }

    /* (non-Javadoc)
     * Method declared on IWizard.
     */
    public boolean performFinish() {
        return mainPage.finish();
    }
}

