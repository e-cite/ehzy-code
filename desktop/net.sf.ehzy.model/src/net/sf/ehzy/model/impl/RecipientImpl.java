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

import java.util.Date;

import net.sf.ehzy.model.Meter;
import net.sf.ehzy.model.ModelPackage;
import net.sf.ehzy.model.Recipient;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recipient</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.ehzy.model.impl.RecipientImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.RecipientImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.RecipientImpl#getSalutation <em>Salutation</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.RecipientImpl#getLastMessageDate <em>Last Message Date</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.RecipientImpl#getMeter <em>Meter</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.RecipientImpl#isUpdatedReadoutsAvailable <em>Updated Readouts Available</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecipientImpl extends EObjectImpl implements Recipient {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSalutation() <em>Salutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalutation()
	 * @generated
	 * @ordered
	 */
	protected static final String SALUTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSalutation() <em>Salutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalutation()
	 * @generated
	 * @ordered
	 */
	protected String salutation = SALUTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastMessageDate() <em>Last Message Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastMessageDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_MESSAGE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastMessageDate() <em>Last Message Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastMessageDate()
	 * @generated
	 * @ordered
	 */
	protected Date lastMessageDate = LAST_MESSAGE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isUpdatedReadoutsAvailable() <em>Updated Readouts Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUpdatedReadoutsAvailable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UPDATED_READOUTS_AVAILABLE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecipientImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.RECIPIENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RECIPIENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RECIPIENT__ADDRESS, oldAddress, address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalutation(String newSalutation) {
		String oldSalutation = salutation;
		salutation = newSalutation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RECIPIENT__SALUTATION, oldSalutation, salutation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastMessageDate() {
		return lastMessageDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastMessageDate(Date newLastMessageDate) {
		Date oldLastMessageDate = lastMessageDate;
		lastMessageDate = newLastMessageDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RECIPIENT__LAST_MESSAGE_DATE, oldLastMessageDate, lastMessageDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meter getMeter() {
		if (eContainerFeatureID() != ModelPackage.RECIPIENT__METER) return null;
		return (Meter)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @return the {@link NotificationChain} 
	 * <!-- end-user-doc -->
	 * @param newMeter 
	 * @param msgs 
	 * @generated
	 */
	public NotificationChain basicSetMeter(Meter newMeter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMeter, ModelPackage.RECIPIENT__METER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeter(Meter newMeter) {
		if (newMeter != eInternalContainer() || (eContainerFeatureID() != ModelPackage.RECIPIENT__METER && newMeter != null)) {
			if (EcoreUtil.isAncestor(this, newMeter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMeter != null)
				msgs = ((InternalEObject)newMeter).eInverseAdd(this, ModelPackage.METER__RECIPIENTS, Meter.class, msgs);
			msgs = basicSetMeter(newMeter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RECIPIENT__METER, newMeter, newMeter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated and changed
	 */
	public boolean isUpdatedReadoutsAvailable() {
		Date lastMessageDate = getLastMessageDate();
		Date lastReadoutDate = getMeter().getLastReadoutDate();
		return ((lastMessageDate == null) && (lastReadoutDate != null)) ||
				((lastMessageDate != null) && (lastReadoutDate != null) && (getMeter().getLastReadoutDate().compareTo(getLastMessageDate()) > 0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.RECIPIENT__METER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMeter((Meter)otherEnd, msgs);
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
			case ModelPackage.RECIPIENT__METER:
				return basicSetMeter(null, msgs);
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
			case ModelPackage.RECIPIENT__METER:
				return eInternalContainer().eInverseRemove(this, ModelPackage.METER__RECIPIENTS, Meter.class, msgs);
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
			case ModelPackage.RECIPIENT__NAME:
				return getName();
			case ModelPackage.RECIPIENT__ADDRESS:
				return getAddress();
			case ModelPackage.RECIPIENT__SALUTATION:
				return getSalutation();
			case ModelPackage.RECIPIENT__LAST_MESSAGE_DATE:
				return getLastMessageDate();
			case ModelPackage.RECIPIENT__METER:
				return getMeter();
			case ModelPackage.RECIPIENT__UPDATED_READOUTS_AVAILABLE:
				return isUpdatedReadoutsAvailable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.RECIPIENT__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.RECIPIENT__ADDRESS:
				setAddress((String)newValue);
				return;
			case ModelPackage.RECIPIENT__SALUTATION:
				setSalutation((String)newValue);
				return;
			case ModelPackage.RECIPIENT__LAST_MESSAGE_DATE:
				setLastMessageDate((Date)newValue);
				return;
			case ModelPackage.RECIPIENT__METER:
				setMeter((Meter)newValue);
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
			case ModelPackage.RECIPIENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.RECIPIENT__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
				return;
			case ModelPackage.RECIPIENT__SALUTATION:
				setSalutation(SALUTATION_EDEFAULT);
				return;
			case ModelPackage.RECIPIENT__LAST_MESSAGE_DATE:
				setLastMessageDate(LAST_MESSAGE_DATE_EDEFAULT);
				return;
			case ModelPackage.RECIPIENT__METER:
				setMeter((Meter)null);
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
			case ModelPackage.RECIPIENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.RECIPIENT__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
			case ModelPackage.RECIPIENT__SALUTATION:
				return SALUTATION_EDEFAULT == null ? salutation != null : !SALUTATION_EDEFAULT.equals(salutation);
			case ModelPackage.RECIPIENT__LAST_MESSAGE_DATE:
				return LAST_MESSAGE_DATE_EDEFAULT == null ? lastMessageDate != null : !LAST_MESSAGE_DATE_EDEFAULT.equals(lastMessageDate);
			case ModelPackage.RECIPIENT__METER:
				return getMeter() != null;
			case ModelPackage.RECIPIENT__UPDATED_READOUTS_AVAILABLE:
				return isUpdatedReadoutsAvailable() != UPDATED_READOUTS_AVAILABLE_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", address: ");
		result.append(address);
		result.append(", salutation: ");
		result.append(salutation);
		result.append(", lastMessageDate: ");
		result.append(lastMessageDate);
		result.append(')');
		return result.toString();
	}

} //RecipientImpl
