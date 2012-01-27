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
package net.sf.ehzy.model.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import net.sf.ehzy.model.Location;
import net.sf.ehzy.model.Meter;
import net.sf.ehzy.model.ModelPackage;
import net.sf.ehzy.model.Readout;
import net.sf.ehzy.model.Recipient;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.ehzy.model.impl.MeterImpl#getDeviceID <em>Device ID</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.MeterImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.MeterImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.MeterImpl#getLastReadoutDate <em>Last Readout Date</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.MeterImpl#getRecipients <em>Recipients</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.MeterImpl#getReadouts <em>Readouts</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.MeterImpl#getSortedReadouts <em>Sorted Readouts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeterImpl extends EObjectImpl implements Meter {
	/**
	 * The default value of the '{@link #getDeviceID() <em>Device ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceID()
	 * @generated
	 * @ordered
	 */
	protected static final String DEVICE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeviceID() <em>Device ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceID()
	 * @generated
	 * @ordered
	 */
	protected String deviceID = DEVICE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastReadoutDate() <em>Last Readout Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastReadoutDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_READOUT_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecipients() <em>Recipients</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecipients()
	 * @generated
	 * @ordered
	 */
	protected EList<Recipient> recipients;

	/**
	 * The cached value of the '{@link #getReadouts() <em>Readouts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadouts()
	 * @generated
	 * @ordered
	 */
	protected EList<Readout> readouts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.METER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeviceID() {
		return deviceID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeviceID(String newDeviceID) {
		String oldDeviceID = deviceID;
		deviceID = newDeviceID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.METER__DEVICE_ID, oldDeviceID, deviceID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLocation() {
		if (eContainerFeatureID() != ModelPackage.METER__LOCATION) return null;
		return (Location)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @return the {@link NotificationChain} 
	 * <!-- end-user-doc -->
	 * @param newLocation 
	 * @param msgs 
	 * @generated
	 */
	public NotificationChain basicSetLocation(Location newLocation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLocation, ModelPackage.METER__LOCATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Location newLocation) {
		if (newLocation != eInternalContainer() || (eContainerFeatureID() != ModelPackage.METER__LOCATION && newLocation != null)) {
			if (EcoreUtil.isAncestor(this, newLocation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, ModelPackage.LOCATION__METERS, Location.class, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.METER__LOCATION, newLocation, newLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.METER__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated and changed
	 */
	public Date getLastReadoutDate() {
		Date dc = null;
		for (Readout r: getReadouts()) {
			final Date dr = r.getDate();
			if ((dc == null) || (dc.compareTo(dr) < 0)) {
				dc = dr;
			}
		}
		return dc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Recipient> getRecipients() {
		if (recipients == null) {
			recipients = new EObjectContainmentWithInverseEList<Recipient>(Recipient.class, this, ModelPackage.METER__RECIPIENTS, ModelPackage.RECIPIENT__METER);
		}
		return recipients;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Readout> getReadouts() {
		if (readouts == null) {
			readouts = new EObjectContainmentWithInverseEList<Readout>(Readout.class, this, ModelPackage.METER__READOUTS, ModelPackage.READOUT__METER);
		}
		return readouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns a sorted copy of the readouts.
	 * <!-- end-user-doc -->
	 * @generated and changed
	 */
	public EList<Readout> getSortedReadouts() {
		EList<Readout> r = new EObjectEList<Readout>(Readout.class, this, ModelPackage.METER__SORTED_READOUTS);
		r.addAll(getReadouts());
		ECollections.sort(r, new Comparator<Readout>() {
			@Override
			public int compare(Readout r1, Readout r2) {
				return r1.getDate().compareTo(r2.getDate());
			}
		});
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated and changed
	 */
	public EList<Readout> getMostRecentReadouts(int maxNumber) {
		EList<Readout> r = getSortedReadouts();
		while (r.size() > maxNumber) {
			r.remove(0);
		}
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.METER__LOCATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLocation((Location)otherEnd, msgs);
			case ModelPackage.METER__RECIPIENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRecipients()).basicAdd(otherEnd, msgs);
			case ModelPackage.METER__READOUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReadouts()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.METER__LOCATION:
				return basicSetLocation(null, msgs);
			case ModelPackage.METER__RECIPIENTS:
				return ((InternalEList<?>)getRecipients()).basicRemove(otherEnd, msgs);
			case ModelPackage.METER__READOUTS:
				return ((InternalEList<?>)getReadouts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.METER__LOCATION:
				return eInternalContainer().eInverseRemove(this, ModelPackage.LOCATION__METERS, Location.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.METER__DEVICE_ID:
				return getDeviceID();
			case ModelPackage.METER__LOCATION:
				return getLocation();
			case ModelPackage.METER__DESCRIPTION:
				return getDescription();
			case ModelPackage.METER__LAST_READOUT_DATE:
				return getLastReadoutDate();
			case ModelPackage.METER__RECIPIENTS:
				return getRecipients();
			case ModelPackage.METER__READOUTS:
				return getReadouts();
			case ModelPackage.METER__SORTED_READOUTS:
				return getSortedReadouts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.METER__DEVICE_ID:
				setDeviceID((String)newValue);
				return;
			case ModelPackage.METER__LOCATION:
				setLocation((Location)newValue);
				return;
			case ModelPackage.METER__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.METER__RECIPIENTS:
				getRecipients().clear();
				getRecipients().addAll((Collection<? extends Recipient>)newValue);
				return;
			case ModelPackage.METER__READOUTS:
				getReadouts().clear();
				getReadouts().addAll((Collection<? extends Readout>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.METER__DEVICE_ID:
				setDeviceID(DEVICE_ID_EDEFAULT);
				return;
			case ModelPackage.METER__LOCATION:
				setLocation((Location)null);
				return;
			case ModelPackage.METER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.METER__RECIPIENTS:
				getRecipients().clear();
				return;
			case ModelPackage.METER__READOUTS:
				getReadouts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.METER__DEVICE_ID:
				return DEVICE_ID_EDEFAULT == null ? deviceID != null : !DEVICE_ID_EDEFAULT.equals(deviceID);
			case ModelPackage.METER__LOCATION:
				return getLocation() != null;
			case ModelPackage.METER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.METER__LAST_READOUT_DATE:
				return LAST_READOUT_DATE_EDEFAULT == null ? getLastReadoutDate() != null : !LAST_READOUT_DATE_EDEFAULT.equals(getLastReadoutDate());
			case ModelPackage.METER__RECIPIENTS:
				return recipients != null && !recipients.isEmpty();
			case ModelPackage.METER__READOUTS:
				return readouts != null && !readouts.isEmpty();
			case ModelPackage.METER__SORTED_READOUTS:
				return !getSortedReadouts().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (deviceID: ");
		result.append(deviceID);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //MeterImpl
