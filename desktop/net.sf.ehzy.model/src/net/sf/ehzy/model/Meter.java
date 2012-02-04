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
package net.sf.ehzy.model;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.ehzy.model.Meter#getDeviceID <em>Device ID</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Meter#getLocation <em>Location</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Meter#getDescription <em>Description</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Meter#getLastReadoutDate <em>Last Readout Date</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Meter#getRecipients <em>Recipients</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Meter#getReadouts <em>Readouts</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Meter#getSortedReadouts <em>Sorted Readouts</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Meter#getValueRetentionTime <em>Value Retention Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.ehzy.model.ModelPackage#getMeter()
 * @model
 * @generated
 */
public interface Meter extends EObject {
	/**
	 * Returns the value of the '<em><b>Device ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device ID</em>' attribute.
	 * @see #setDeviceID(String)
	 * @see net.sf.ehzy.model.ModelPackage#getMeter_DeviceID()
	 * @model id="true" required="true" ordered="false"
	 * @generated
	 */
	String getDeviceID();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Meter#getDeviceID <em>Device ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device ID</em>' attribute.
	 * @see #getDeviceID()
	 * @generated
	 */
	void setDeviceID(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.sf.ehzy.model.Location#getMeters <em>Meters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' container reference.
	 * @see #setLocation(Location)
	 * @see net.sf.ehzy.model.ModelPackage#getMeter_Location()
	 * @see net.sf.ehzy.model.Location#getMeters
	 * @model opposite="meters" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Location getLocation();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Meter#getLocation <em>Location</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' container reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Location value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see net.sf.ehzy.model.ModelPackage#getMeter_Description()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Meter#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Last Readout Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Readout Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Readout Date</em>' attribute.
	 * @see net.sf.ehzy.model.ModelPackage#getMeter_LastReadoutDate()
	 * @model unique="false" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Date getLastReadoutDate();

	/**
	 * Returns the value of the '<em><b>Recipients</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.ehzy.model.Recipient}.
	 * It is bidirectional and its opposite is '{@link net.sf.ehzy.model.Recipient#getMeter <em>Meter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipients</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recipients</em>' containment reference list.
	 * @see net.sf.ehzy.model.ModelPackage#getMeter_Recipients()
	 * @see net.sf.ehzy.model.Recipient#getMeter
	 * @model opposite="meter" containment="true"
	 * @generated
	 */
	EList<Recipient> getRecipients();

	/**
	 * Returns the value of the '<em><b>Readouts</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.ehzy.model.Readout}.
	 * It is bidirectional and its opposite is '{@link net.sf.ehzy.model.Readout#getMeter <em>Meter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Readouts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Readouts</em>' containment reference list.
	 * @see net.sf.ehzy.model.ModelPackage#getMeter_Readouts()
	 * @see net.sf.ehzy.model.Readout#getMeter
	 * @model opposite="meter" containment="true" keys="date"
	 * @generated
	 */
	EList<Readout> getReadouts();

	/**
	 * Returns the value of the '<em><b>Sorted Readouts</b></em>' reference list.
	 * The list contents are of type {@link net.sf.ehzy.model.Readout}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sorted Readouts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sorted Readouts</em>' reference list.
	 * @see net.sf.ehzy.model.ModelPackage#getMeter_SortedReadouts()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Readout> getSortedReadouts();

	/**
	 * Returns the value of the '<em><b>Value Retention Time</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Retention Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Retention Time</em>' attribute.
	 * @see #setValueRetentionTime(int)
	 * @see net.sf.ehzy.model.ModelPackage#getMeter_ValueRetentionTime()
	 * @model default="-1" unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getValueRetentionTime();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Meter#getValueRetentionTime <em>Value Retention Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Retention Time</em>' attribute.
	 * @see #getValueRetentionTime()
	 * @generated
	 */
	void setValueRetentionTime(int value);

	/**
	 * <!-- begin-user-doc -->
	 * @param maxNumber 
	 * @return a list containing the most recent up to maxNumber Readouts  
	 * <!-- end-user-doc -->
	 * @model maxNumberUnique="false" maxNumberRequired="true" maxNumberOrdered="false"
	 * @generated
	 */
	EList<Readout> getMostRecentReadouts(int maxNumber);

} // Meter
