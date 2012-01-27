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

import java.math.BigDecimal;
import java.util.Date;

import net.sf.ehzy.model.Meter;
import net.sf.ehzy.model.ModelPackage;
import net.sf.ehzy.model.Readout;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Readout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.ehzy.model.impl.ReadoutImpl#getMeter <em>Meter</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.ReadoutImpl#getDate <em>Date</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.ReadoutImpl#getMessageContents <em>Message Contents</em>}</li>
 *   <li>{@link net.sf.ehzy.model.impl.ReadoutImpl#getTotalConsumption <em>Total Consumption</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReadoutImpl extends EObjectImpl implements Readout {
	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessageContents() <em>Message Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageContents()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] MESSAGE_CONTENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessageContents() <em>Message Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageContents()
	 * @generated
	 * @ordered
	 */
	protected byte[] messageContents = MESSAGE_CONTENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalConsumption() <em>Total Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalConsumption()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal TOTAL_CONSUMPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTotalConsumption() <em>Total Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalConsumption()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal totalConsumption = TOTAL_CONSUMPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.READOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meter getMeter() {
		if (eContainerFeatureID() != ModelPackage.READOUT__METER) return null;
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
		msgs = eBasicSetContainer((InternalEObject)newMeter, ModelPackage.READOUT__METER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeter(Meter newMeter) {
		if (newMeter != eInternalContainer() || (eContainerFeatureID() != ModelPackage.READOUT__METER && newMeter != null)) {
			if (EcoreUtil.isAncestor(this, newMeter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMeter != null)
				msgs = ((InternalEObject)newMeter).eInverseAdd(this, ModelPackage.METER__READOUTS, Meter.class, msgs);
			msgs = basicSetMeter(newMeter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.READOUT__METER, newMeter, newMeter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.READOUT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getMessageContents() {
		return messageContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageContents(byte[] newMessageContents) {
		byte[] oldMessageContents = messageContents;
		messageContents = newMessageContents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.READOUT__MESSAGE_CONTENTS, oldMessageContents, messageContents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getTotalConsumption() {
		return totalConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalConsumption(BigDecimal newTotalConsumption) {
		BigDecimal oldTotalConsumption = totalConsumption;
		totalConsumption = newTotalConsumption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.READOUT__TOTAL_CONSUMPTION, oldTotalConsumption, totalConsumption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.READOUT__METER:
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
			case ModelPackage.READOUT__METER:
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
			case ModelPackage.READOUT__METER:
				return eInternalContainer().eInverseRemove(this, ModelPackage.METER__READOUTS, Meter.class, msgs);
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
			case ModelPackage.READOUT__METER:
				return getMeter();
			case ModelPackage.READOUT__DATE:
				return getDate();
			case ModelPackage.READOUT__MESSAGE_CONTENTS:
				return getMessageContents();
			case ModelPackage.READOUT__TOTAL_CONSUMPTION:
				return getTotalConsumption();
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
			case ModelPackage.READOUT__METER:
				setMeter((Meter)newValue);
				return;
			case ModelPackage.READOUT__DATE:
				setDate((Date)newValue);
				return;
			case ModelPackage.READOUT__MESSAGE_CONTENTS:
				setMessageContents((byte[])newValue);
				return;
			case ModelPackage.READOUT__TOTAL_CONSUMPTION:
				setTotalConsumption((BigDecimal)newValue);
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
			case ModelPackage.READOUT__METER:
				setMeter((Meter)null);
				return;
			case ModelPackage.READOUT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case ModelPackage.READOUT__MESSAGE_CONTENTS:
				setMessageContents(MESSAGE_CONTENTS_EDEFAULT);
				return;
			case ModelPackage.READOUT__TOTAL_CONSUMPTION:
				setTotalConsumption(TOTAL_CONSUMPTION_EDEFAULT);
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
			case ModelPackage.READOUT__METER:
				return getMeter() != null;
			case ModelPackage.READOUT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case ModelPackage.READOUT__MESSAGE_CONTENTS:
				return MESSAGE_CONTENTS_EDEFAULT == null ? messageContents != null : !MESSAGE_CONTENTS_EDEFAULT.equals(messageContents);
			case ModelPackage.READOUT__TOTAL_CONSUMPTION:
				return TOTAL_CONSUMPTION_EDEFAULT == null ? totalConsumption != null : !TOTAL_CONSUMPTION_EDEFAULT.equals(totalConsumption);
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
		result.append(" (date: ");
		result.append(date);
		result.append(", messageContents: ");
		result.append(messageContents);
		result.append(", totalConsumption: ");
		result.append(totalConsumption);
		result.append(')');
		return result.toString();
	}

} //ReadoutImpl
