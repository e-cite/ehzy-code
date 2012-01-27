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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.ehzy.model.Location#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Location#getMeters <em>Meters</em>}</li>
 *   <li>{@link net.sf.ehzy.model.Location#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.ehzy.model.ModelPackage#getLocation()
 * @model
 * @generated
 */
public interface Location extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see net.sf.ehzy.model.ModelPackage#getLocation_Name()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Location#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Meters</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.ehzy.model.Meter}.
	 * It is bidirectional and its opposite is '{@link net.sf.ehzy.model.Meter#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meters</em>' containment reference list.
	 * @see net.sf.ehzy.model.ModelPackage#getLocation_Meters()
	 * @see net.sf.ehzy.model.Meter#getLocation
	 * @model opposite="location" containment="true" keys="deviceID"
	 * @generated
	 */
	EList<Meter> getMeters();

	/**
	 * Returns the value of the '<em><b>Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.sf.ehzy.model.Project#getLocations <em>Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' container reference.
	 * @see #setProject(Project)
	 * @see net.sf.ehzy.model.ModelPackage#getLocation_Project()
	 * @see net.sf.ehzy.model.Project#getLocations
	 * @model opposite="locations" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link net.sf.ehzy.model.Location#getProject <em>Project</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' container reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

} // Location
