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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recipient</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.ehzy.model.Recipient#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Recipient#getAddress <em>Address</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Recipient#getSalutation <em>Salutation</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Recipient#getLastMessageDate <em>Last Message Date</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Recipient#getMeter <em>Meter</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Recipient#isUpdatedReadoutsAvailable <em>Updated Readouts Available</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.ehzy.model.ModelPackage#getRecipient()
 * @model
 * @generated
 */
public interface Recipient extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see net.sf.ehzy.model.ModelPackage#getRecipient_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Recipient#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see #setAddress(String)
	 * @see net.sf.ehzy.model.ModelPackage#getRecipient_Address()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getAddress();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Recipient#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(String value);

	/**
	 * Returns the value of the '<em><b>Salutation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salutation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salutation</em>' attribute.
	 * @see #setSalutation(String)
	 * @see net.sf.ehzy.model.ModelPackage#getRecipient_Salutation()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getSalutation();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Recipient#getSalutation <em>Salutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Salutation</em>' attribute.
	 * @see #getSalutation()
	 * @generated
	 */
	void setSalutation(String value);

	/**
	 * Returns the value of the '<em><b>Last Message Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Message Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Message Date</em>' attribute.
	 * @see #setLastMessageDate(Date)
	 * @see net.sf.ehzy.model.ModelPackage#getRecipient_LastMessageDate()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	Date getLastMessageDate();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Recipient#getLastMessageDate <em>Last Message Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Message Date</em>' attribute.
	 * @see #getLastMessageDate()
	 * @generated
	 */
	void setLastMessageDate(Date value);

	/**
	 * Returns the value of the '<em><b>Meter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.sf.ehzy.model.Meter#getRecipients <em>Recipients</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meter</em>' container reference.
	 * @see #setMeter(Meter)
	 * @see net.sf.ehzy.model.ModelPackage#getRecipient_Meter()
	 * @see net.sf.ehzy.model.Meter#getRecipients
	 * @model opposite="recipients" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Meter getMeter();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Recipient#getMeter <em>Meter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meter</em>' container reference.
	 * @see #getMeter()
	 * @generated
	 */
	void setMeter(Meter value);

	/**
	 * Returns the value of the '<em><b>Updated Readouts Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated Readouts Available</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated Readouts Available</em>' attribute.
	 * @see net.sf.ehzy.model.ModelPackage#getRecipient_UpdatedReadoutsAvailable()
	 * @model unique="false" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isUpdatedReadoutsAvailable();

} // Recipient
