package process.diagram.actions;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DiagramUIMessages {
	private static final String BUNDLE_NAME = "process.diagram.actions.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private DiagramUIMessages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
