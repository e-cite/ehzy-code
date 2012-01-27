/*******************************************************************************
 * Copyright (c) 2012 Volker Wegert and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Volker Wegert - initial API and implementation
 *******************************************************************************/
package net.sf.ehzy.model.provider;


import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import net.sf.ehzy.model.ModelPackage;
import net.sf.ehzy.model.Readout;
import net.sf.ehzy.preferences.IPreferences;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * This is the item provider adapter for a {@link net.sf.ehzy.model.Readout} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReadoutItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	
	private SimpleDateFormat dateFormat;

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param adapterFactory 
	 * @generated and changed
	 */
	public ReadoutItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		BundleContext context = EHZyEditPlugin.getPlugin().getBundle().getBundleContext();
		ServiceReference<IPreferences> reference = context.getServiceReference(IPreferences.class);
		IPreferences preferences = context.getService(reference);
		dateFormat = new SimpleDateFormat(preferences.getDateFormat());
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDatePropertyDescriptor(object);
			addMessageContentsPropertyDescriptor(object);
			addTotalConsumptionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object 
	 * @generated
	 */
	protected void addDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Readout_date_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Readout_date_feature", "_UI_Readout_type"),
				 ModelPackage.Literals.READOUT__DATE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Message Contents feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object 
	 * @generated
	 */
	protected void addMessageContentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Readout_messageContents_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Readout_messageContents_feature", "_UI_Readout_type"),
				 ModelPackage.Literals.READOUT__MESSAGE_CONTENTS,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Total Consumption feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object 
	 * @generated
	 */
	protected void addTotalConsumptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Readout_totalConsumption_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Readout_totalConsumption_feature", "_UI_Readout_type"),
				 ModelPackage.Literals.READOUT__TOTAL_CONSUMPTION,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Readout.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Readout"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated and changed
	 */
	@Override
	public String getText(Object object) {
		Date labelValue = ((Readout)object).getDate();
		String label = labelValue == null ? null : dateFormat.format(labelValue);
		return label == null || label.length() == 0 ?
			getString("_UI_Readout_type") :
			getString("_UI_Readout_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Readout.class)) {
			case ModelPackage.READOUT__DATE:
			case ModelPackage.READOUT__MESSAGE_CONTENTS:
			case ModelPackage.READOUT__TOTAL_CONSUMPTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EHZyEditPlugin.INSTANCE;
	}

}
