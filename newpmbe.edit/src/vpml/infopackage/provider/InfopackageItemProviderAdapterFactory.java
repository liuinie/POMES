/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package vpml.infopackage.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import vpml.infopackage.util.InfopackageAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InfopackageItemProviderAdapterFactory extends InfopackageAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection supportedTypes = new ArrayList();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfopackageItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);		
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMILeafProduct} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMILeafProductItemProvider emiLeafProductItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMILeafProduct}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMILeafProductAdapter() {
		if (emiLeafProductItemProvider == null) {
			emiLeafProductItemProvider = new EMILeafProductItemProvider(this);
		}

		return emiLeafProductItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIDocument} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIDocumentItemProvider emiDocumentItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIDocument}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIDocumentAdapter() {
		if (emiDocumentItemProvider == null) {
			emiDocumentItemProvider = new EMIDocumentItemProvider(this);
		}

		return emiDocumentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIArtifact} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIArtifactItemProvider emiArtifactItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIArtifact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIArtifactAdapter() {
		if (emiArtifactItemProvider == null) {
			emiArtifactItemProvider = new EMIArtifactItemProvider(this);
		}

		return emiArtifactItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIMessage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIMessageItemProvider emiMessageItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIMessage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIMessageAdapter() {
		if (emiMessageItemProvider == null) {
			emiMessageItemProvider = new EMIMessageItemProvider(this);
		}

		return emiMessageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIOther} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIOtherItemProvider emiOtherItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIOther}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIOtherAdapter() {
		if (emiOtherItemProvider == null) {
			emiOtherItemProvider = new EMIOtherItemProvider(this);
		}

		return emiOtherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIProductPackage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIProductPackageItemProvider emiProductPackageItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIProductPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIProductPackageAdapter() {
		if (emiProductPackageItemProvider == null) {
			emiProductPackageItemProvider = new EMIProductPackageItemProvider(this);
		}

		return emiProductPackageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIObject} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIObjectItemProvider emiObjectItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIObjectAdapter() {
		if (emiObjectItemProvider == null) {
			emiObjectItemProvider = new EMIObjectItemProvider(this);
		}

		return emiObjectItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMILogicalConnector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMILogicalConnectorItemProvider emiLogicalConnectorItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMILogicalConnector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMILogicalConnectorAdapter() {
		if (emiLogicalConnectorItemProvider == null) {
			emiLogicalConnectorItemProvider = new EMILogicalConnectorItemProvider(this);
		}

		return emiLogicalConnectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIComInfo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIComInfoItemProvider emiComInfoItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIComInfo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIComInfoAdapter() {
		if (emiComInfoItemProvider == null) {
			emiComInfoItemProvider = new EMIComInfoItemProvider(this);
		}

		return emiComInfoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIProduct} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIProductItemProvider emiProductItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIProduct}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIProductAdapter() {
		if (emiProductItemProvider == null) {
			emiProductItemProvider = new EMIProductItemProvider(this);
		}

		return emiProductItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIFlowItemProvider emiFlowItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIFlowAdapter() {
		if (emiFlowItemProvider == null) {
			emiFlowItemProvider = new EMIFlowItemProvider(this);
		}

		return emiFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMINode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMINodeItemProvider emiNodeItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMINode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMINodeAdapter() {
		if (emiNodeItemProvider == null) {
			emiNodeItemProvider = new EMINodeItemProvider(this);
		}

		return emiNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIRefFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIRefFlowItemProvider emiRefFlowItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIRefFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIRefFlowAdapter() {
		if (emiRefFlowItemProvider == null) {
			emiRefFlowItemProvider = new EMIRefFlowItemProvider(this);
		}

		return emiRefFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIDataFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIDataFlowItemProvider emiDataFlowItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIDataFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIDataFlowAdapter() {
		if (emiDataFlowItemProvider == null) {
			emiDataFlowItemProvider = new EMIDataFlowItemProvider(this);
		}

		return emiDataFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIInConnector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIInConnectorItemProvider emiInConnectorItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIInConnector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIInConnectorAdapter() {
		if (emiInConnectorItemProvider == null) {
			emiInConnectorItemProvider = new EMIInConnectorItemProvider(this);
		}

		return emiInConnectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIOutConnector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIOutConnectorItemProvider emiOutConnectorItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIOutConnector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIOutConnectorAdapter() {
		if (emiOutConnectorItemProvider == null) {
			emiOutConnectorItemProvider = new EMIOutConnectorItemProvider(this);
		}

		return emiOutConnectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIStateConnector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIStateConnectorItemProvider emiStateConnectorItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIStateConnector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIStateConnectorAdapter() {
		if (emiStateConnectorItemProvider == null) {
			emiStateConnectorItemProvider = new EMIStateConnectorItemProvider(this);
		}

		return emiStateConnectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIInOr} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIInOrItemProvider emiInOrItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIInOr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIInOrAdapter() {
		if (emiInOrItemProvider == null) {
			emiInOrItemProvider = new EMIInOrItemProvider(this);
		}

		return emiInOrItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIInAnd} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIInAndItemProvider emiInAndItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIInAnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIInAndAdapter() {
		if (emiInAndItemProvider == null) {
			emiInAndItemProvider = new EMIInAndItemProvider(this);
		}

		return emiInAndItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIOutAnd} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIOutAndItemProvider emiOutAndItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIOutAnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIOutAndAdapter() {
		if (emiOutAndItemProvider == null) {
			emiOutAndItemProvider = new EMIOutAndItemProvider(this);
		}

		return emiOutAndItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIOutOr} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIOutOrItemProvider emiOutOrItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIOutOr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIOutOrAdapter() {
		if (emiOutOrItemProvider == null) {
			emiOutOrItemProvider = new EMIOutOrItemProvider(this);
		}

		return emiOutOrItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link vpml.infopackage.EMIDiagram} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMIDiagramItemProvider emiDiagramItemProvider;

	/**
	 * This creates an adapter for a {@link vpml.infopackage.EMIDiagram}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createEMIDiagramAdapter() {
		if (emiDiagramItemProvider == null) {
			emiDiagramItemProvider = new EMIDiagramItemProvider(this);
		}

		return emiDiagramItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (emiLeafProductItemProvider != null) emiLeafProductItemProvider.dispose();
		if (emiDocumentItemProvider != null) emiDocumentItemProvider.dispose();
		if (emiArtifactItemProvider != null) emiArtifactItemProvider.dispose();
		if (emiMessageItemProvider != null) emiMessageItemProvider.dispose();
		if (emiOtherItemProvider != null) emiOtherItemProvider.dispose();
		if (emiProductPackageItemProvider != null) emiProductPackageItemProvider.dispose();
		if (emiObjectItemProvider != null) emiObjectItemProvider.dispose();
		if (emiLogicalConnectorItemProvider != null) emiLogicalConnectorItemProvider.dispose();
		if (emiComInfoItemProvider != null) emiComInfoItemProvider.dispose();
		if (emiProductItemProvider != null) emiProductItemProvider.dispose();
		if (emiFlowItemProvider != null) emiFlowItemProvider.dispose();
		if (emiNodeItemProvider != null) emiNodeItemProvider.dispose();
		if (emiRefFlowItemProvider != null) emiRefFlowItemProvider.dispose();
		if (emiDataFlowItemProvider != null) emiDataFlowItemProvider.dispose();
		if (emiInConnectorItemProvider != null) emiInConnectorItemProvider.dispose();
		if (emiOutConnectorItemProvider != null) emiOutConnectorItemProvider.dispose();
		if (emiStateConnectorItemProvider != null) emiStateConnectorItemProvider.dispose();
		if (emiInOrItemProvider != null) emiInOrItemProvider.dispose();
		if (emiInAndItemProvider != null) emiInAndItemProvider.dispose();
		if (emiOutAndItemProvider != null) emiOutAndItemProvider.dispose();
		if (emiOutOrItemProvider != null) emiOutOrItemProvider.dispose();
		if (emiDiagramItemProvider != null) emiDiagramItemProvider.dispose();
	}

}
