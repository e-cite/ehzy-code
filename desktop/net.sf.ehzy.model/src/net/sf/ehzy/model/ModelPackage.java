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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.sf.ehzy.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ehzy.sf.net/model/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "net.sf.eHZy";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = net.sf.ehzy.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link net.sf.ehzy.model.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.ehzy.model.impl.ProjectImpl
	 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Locations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__LOCATIONS = 0;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link net.sf.ehzy.model.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.ehzy.model.impl.LocationImpl
	 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Meters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__METERS = 1;

	/**
	 * The feature id for the '<em><b>Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__PROJECT = 2;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link net.sf.ehzy.model.impl.MeterImpl <em>Meter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.ehzy.model.impl.MeterImpl
	 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getMeter()
	 * @generated
	 */
	int METER = 2;

	/**
	 * The feature id for the '<em><b>Device ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METER__DEVICE_ID = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METER__LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METER__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Last Readout Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METER__LAST_READOUT_DATE = 3;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METER__RECIPIENTS = 4;

	/**
	 * The feature id for the '<em><b>Readouts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METER__READOUTS = 5;

	/**
	 * The feature id for the '<em><b>Sorted Readouts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METER__SORTED_READOUTS = 6;

	/**
	 * The number of structural features of the '<em>Meter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METER_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link net.sf.ehzy.model.impl.RecipientImpl <em>Recipient</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.ehzy.model.impl.RecipientImpl
	 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getRecipient()
	 * @generated
	 */
	int RECIPIENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>Salutation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__SALUTATION = 2;

	/**
	 * The feature id for the '<em><b>Last Message Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__LAST_MESSAGE_DATE = 3;

	/**
	 * The feature id for the '<em><b>Meter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__METER = 4;

	/**
	 * The feature id for the '<em><b>Updated Readouts Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__UPDATED_READOUTS_AVAILABLE = 5;

	/**
	 * The number of structural features of the '<em>Recipient</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link net.sf.ehzy.model.impl.ReadoutImpl <em>Readout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.ehzy.model.impl.ReadoutImpl
	 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getReadout()
	 * @generated
	 */
	int READOUT = 4;

	/**
	 * The feature id for the '<em><b>Meter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READOUT__METER = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READOUT__DATE = 1;

	/**
	 * The feature id for the '<em><b>Message Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READOUT__MESSAGE_CONTENTS = 2;

	/**
	 * The feature id for the '<em><b>Total Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READOUT__TOTAL_CONSUMPTION = 3;

	/**
	 * The number of structural features of the '<em>Readout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READOUT_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link net.sf.ehzy.model.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see net.sf.ehzy.model.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.ehzy.model.Project#getLocations <em>Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Locations</em>'.
	 * @see net.sf.ehzy.model.Project#getLocations()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Locations();

	/**
	 * Returns the meta object for class '{@link net.sf.ehzy.model.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see net.sf.ehzy.model.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Location#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.ehzy.model.Location#getName()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.ehzy.model.Location#getMeters <em>Meters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Meters</em>'.
	 * @see net.sf.ehzy.model.Location#getMeters()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_Meters();

	/**
	 * Returns the meta object for the container reference '{@link net.sf.ehzy.model.Location#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Project</em>'.
	 * @see net.sf.ehzy.model.Location#getProject()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_Project();

	/**
	 * Returns the meta object for class '{@link net.sf.ehzy.model.Meter <em>Meter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meter</em>'.
	 * @see net.sf.ehzy.model.Meter
	 * @generated
	 */
	EClass getMeter();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Meter#getDeviceID <em>Device ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Device ID</em>'.
	 * @see net.sf.ehzy.model.Meter#getDeviceID()
	 * @see #getMeter()
	 * @generated
	 */
	EAttribute getMeter_DeviceID();

	/**
	 * Returns the meta object for the container reference '{@link net.sf.ehzy.model.Meter#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Location</em>'.
	 * @see net.sf.ehzy.model.Meter#getLocation()
	 * @see #getMeter()
	 * @generated
	 */
	EReference getMeter_Location();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Meter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see net.sf.ehzy.model.Meter#getDescription()
	 * @see #getMeter()
	 * @generated
	 */
	EAttribute getMeter_Description();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Meter#getLastReadoutDate <em>Last Readout Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Readout Date</em>'.
	 * @see net.sf.ehzy.model.Meter#getLastReadoutDate()
	 * @see #getMeter()
	 * @generated
	 */
	EAttribute getMeter_LastReadoutDate();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.ehzy.model.Meter#getRecipients <em>Recipients</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Recipients</em>'.
	 * @see net.sf.ehzy.model.Meter#getRecipients()
	 * @see #getMeter()
	 * @generated
	 */
	EReference getMeter_Recipients();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.ehzy.model.Meter#getReadouts <em>Readouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Readouts</em>'.
	 * @see net.sf.ehzy.model.Meter#getReadouts()
	 * @see #getMeter()
	 * @generated
	 */
	EReference getMeter_Readouts();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.ehzy.model.Meter#getSortedReadouts <em>Sorted Readouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sorted Readouts</em>'.
	 * @see net.sf.ehzy.model.Meter#getSortedReadouts()
	 * @see #getMeter()
	 * @generated
	 */
	EReference getMeter_SortedReadouts();

	/**
	 * Returns the meta object for class '{@link net.sf.ehzy.model.Recipient <em>Recipient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recipient</em>'.
	 * @see net.sf.ehzy.model.Recipient
	 * @generated
	 */
	EClass getRecipient();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Recipient#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.ehzy.model.Recipient#getName()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_Name();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Recipient#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see net.sf.ehzy.model.Recipient#getAddress()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_Address();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Recipient#getSalutation <em>Salutation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Salutation</em>'.
	 * @see net.sf.ehzy.model.Recipient#getSalutation()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_Salutation();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Recipient#getLastMessageDate <em>Last Message Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Message Date</em>'.
	 * @see net.sf.ehzy.model.Recipient#getLastMessageDate()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_LastMessageDate();

	/**
	 * Returns the meta object for the container reference '{@link net.sf.ehzy.model.Recipient#getMeter <em>Meter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Meter</em>'.
	 * @see net.sf.ehzy.model.Recipient#getMeter()
	 * @see #getRecipient()
	 * @generated
	 */
	EReference getRecipient_Meter();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Recipient#isUpdatedReadoutsAvailable <em>Updated Readouts Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Updated Readouts Available</em>'.
	 * @see net.sf.ehzy.model.Recipient#isUpdatedReadoutsAvailable()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_UpdatedReadoutsAvailable();

	/**
	 * Returns the meta object for class '{@link net.sf.ehzy.model.Readout <em>Readout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Readout</em>'.
	 * @see net.sf.ehzy.model.Readout
	 * @generated
	 */
	EClass getReadout();

	/**
	 * Returns the meta object for the container reference '{@link net.sf.ehzy.model.Readout#getMeter <em>Meter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Meter</em>'.
	 * @see net.sf.ehzy.model.Readout#getMeter()
	 * @see #getReadout()
	 * @generated
	 */
	EReference getReadout_Meter();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Readout#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see net.sf.ehzy.model.Readout#getDate()
	 * @see #getReadout()
	 * @generated
	 */
	EAttribute getReadout_Date();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Readout#getMessageContents <em>Message Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Contents</em>'.
	 * @see net.sf.ehzy.model.Readout#getMessageContents()
	 * @see #getReadout()
	 * @generated
	 */
	EAttribute getReadout_MessageContents();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.ehzy.model.Readout#getTotalConsumption <em>Total Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Consumption</em>'.
	 * @see net.sf.ehzy.model.Readout#getTotalConsumption()
	 * @see #getReadout()
	 * @generated
	 */
	EAttribute getReadout_TotalConsumption();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link net.sf.ehzy.model.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.ehzy.model.impl.ProjectImpl
		 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Locations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__LOCATIONS = eINSTANCE.getProject_Locations();

		/**
		 * The meta object literal for the '{@link net.sf.ehzy.model.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.ehzy.model.impl.LocationImpl
		 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__NAME = eINSTANCE.getLocation_Name();

		/**
		 * The meta object literal for the '<em><b>Meters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__METERS = eINSTANCE.getLocation_Meters();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__PROJECT = eINSTANCE.getLocation_Project();

		/**
		 * The meta object literal for the '{@link net.sf.ehzy.model.impl.MeterImpl <em>Meter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.ehzy.model.impl.MeterImpl
		 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getMeter()
		 * @generated
		 */
		EClass METER = eINSTANCE.getMeter();

		/**
		 * The meta object literal for the '<em><b>Device ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METER__DEVICE_ID = eINSTANCE.getMeter_DeviceID();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METER__LOCATION = eINSTANCE.getMeter_Location();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METER__DESCRIPTION = eINSTANCE.getMeter_Description();

		/**
		 * The meta object literal for the '<em><b>Last Readout Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METER__LAST_READOUT_DATE = eINSTANCE.getMeter_LastReadoutDate();

		/**
		 * The meta object literal for the '<em><b>Recipients</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METER__RECIPIENTS = eINSTANCE.getMeter_Recipients();

		/**
		 * The meta object literal for the '<em><b>Readouts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METER__READOUTS = eINSTANCE.getMeter_Readouts();

		/**
		 * The meta object literal for the '<em><b>Sorted Readouts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METER__SORTED_READOUTS = eINSTANCE.getMeter_SortedReadouts();

		/**
		 * The meta object literal for the '{@link net.sf.ehzy.model.impl.RecipientImpl <em>Recipient</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.ehzy.model.impl.RecipientImpl
		 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getRecipient()
		 * @generated
		 */
		EClass RECIPIENT = eINSTANCE.getRecipient();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__NAME = eINSTANCE.getRecipient_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__ADDRESS = eINSTANCE.getRecipient_Address();

		/**
		 * The meta object literal for the '<em><b>Salutation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__SALUTATION = eINSTANCE.getRecipient_Salutation();

		/**
		 * The meta object literal for the '<em><b>Last Message Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__LAST_MESSAGE_DATE = eINSTANCE.getRecipient_LastMessageDate();

		/**
		 * The meta object literal for the '<em><b>Meter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECIPIENT__METER = eINSTANCE.getRecipient_Meter();

		/**
		 * The meta object literal for the '<em><b>Updated Readouts Available</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__UPDATED_READOUTS_AVAILABLE = eINSTANCE.getRecipient_UpdatedReadoutsAvailable();

		/**
		 * The meta object literal for the '{@link net.sf.ehzy.model.impl.ReadoutImpl <em>Readout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.ehzy.model.impl.ReadoutImpl
		 * @see net.sf.ehzy.model.impl.ModelPackageImpl#getReadout()
		 * @generated
		 */
		EClass READOUT = eINSTANCE.getReadout();

		/**
		 * The meta object literal for the '<em><b>Meter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READOUT__METER = eINSTANCE.getReadout_Meter();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READOUT__DATE = eINSTANCE.getReadout_Date();

		/**
		 * The meta object literal for the '<em><b>Message Contents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READOUT__MESSAGE_CONTENTS = eINSTANCE.getReadout_MessageContents();

		/**
		 * The meta object literal for the '<em><b>Total Consumption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READOUT__TOTAL_CONSUMPTION = eINSTANCE.getReadout_TotalConsumption();

	}

} //ModelPackage
