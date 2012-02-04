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

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Readout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.ehzy.model.Readout#getMeter <em>Meter</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Readout#getDate <em>Date</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Readout#getMessageContents <em>Message Contents</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Readout#getTotalConsumption <em>Total Consumption</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Readout#isExpired <em>Expired</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.ehzy.model.ModelPackage#getReadout()
 * @model
 * @generated
 */
public interface Readout extends EObject {
	/**
	 * Returns the value of the '<em><b>Meter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.sf.ehzy.model.Meter#getReadouts <em>Readouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meter</em>' container reference.
	 * @see #setMeter(Meter)
	 * @see net.sf.ehzy.model.ModelPackage#getReadout_Meter()
	 * @see net.sf.ehzy.model.Meter#getReadouts
	 * @model opposite="readouts" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Meter getMeter();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Readout#getMeter <em>Meter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meter</em>' container reference.
	 * @see #getMeter()
	 * @generated
	 */
	void setMeter(Meter value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see net.sf.ehzy.model.ModelPackage#getReadout_Date()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Readout#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Message Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Contents</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Contents</em>' attribute.
	 * @see #setMessageContents(byte[])
	 * @see net.sf.ehzy.model.ModelPackage#getReadout_MessageContents()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	byte[] getMessageContents();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Readout#getMessageContents <em>Message Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Contents</em>' attribute.
	 * @see #getMessageContents()
	 * @generated
	 */
	void setMessageContents(byte[] value);

	/**
	 * Returns the value of the '<em><b>Total Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Consumption</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Consumption</em>' attribute.
	 * @see #setTotalConsumption(BigDecimal)
	 * @see net.sf.ehzy.model.ModelPackage#getReadout_TotalConsumption()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	BigDecimal getTotalConsumption();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Readout#getTotalConsumption <em>Total Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Consumption</em>' attribute.
	 * @see #getTotalConsumption()
	 * @generated
	 */
	void setTotalConsumption(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Expired</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expired</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expired</em>' attribute.
	 * @see net.sf.ehzy.model.ModelPackage#getReadout_Expired()
	 * @model unique="false" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isExpired();

} // Readout
