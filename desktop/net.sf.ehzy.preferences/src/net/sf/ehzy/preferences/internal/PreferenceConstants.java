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
package net.sf.ehzy.preferences.internal;

/**
 * Constant definitions for plug-in preferences.
 */
public interface PreferenceConstants {

	/**
	 * Designates the preference that holds the date format set in the preferences.
	 */
	public static final String DATE_FORMAT = "dateFormat"; //$NON-NLS-1$
	
	/**
	 * Designates the preference that holds the OBIS object ID for the total consumption value.
	 */
	public static final String VALUE_OBJECT_ID = "valueObjectID"; //$NON-NLS-1$
	
	/**
	 * Designates the preference that holds the SMTP server name.
	 */
	public static final String SMTP_SERVER = "smtpServer"; //$NON-NLS-1$

	/**
	 * Designates the preference that holds  the SMTP port number.
	 */
	public static final String SMTP_PORT = "smtpPort"; //$NON-NLS-1$
	
	/**
	 * Designates the preference that holds the SMTP user name.
	 */
	public static final String SMTP_USER = "smtpUser"; //$NON-NLS-1$
	
	/**
	 * Designates the preference that holds the SMTP password.
	 */
	public static final String SMTP_PASSWORD = "smtpPassword"; //$NON-NLS-1$
	
	/**
	 * Designates the preference that holds the sender address used to compose the notifications.
	 */
	public static final String SENDER_ADDRESS = "senderAddress"; //$NON-NLS-1$

	/**
	 * Designates the preference that holds the template string to generate the notification subject.
	 */
	public static final String SUBJECT_TEMPLATE = "subjectTemplate"; //$NON-NLS-1$

	/**
	 * Designates the preference that holds the template string to generate the notification body.
	 */
	public static final String BODY_TEMPLATE = "bodyTemplate"; //$NON-NLS-1$
	
}
