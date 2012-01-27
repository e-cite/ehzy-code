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
package net.sf.ehzy.preferences;

/**
 * This is the public interface of the service that provides access to the common eHZy preferences. 
 * @author vwegert
 *
 */
public interface IPreferences {

	/**
	 * Returns the date format set in the preferences.
	 * @return the date format set in the preferences
	 */
	public String getDateFormat();
	
	/**
	 * Returns the OBIS object ID for the total consumption value.
	 * @return the OBIS object ID for the total consumption value
	 */
	public String getValueObjectID();
	
	/**
	 * Returns the SMTP server name.
	 * @return the SMTP server name
	 */
	public String getSMTPServer();
	
	/**
	 * Returns the SMTP port number.
	 * @return the SMTP port number
	 */
	public int getSMTPPort();
	
	/**
	 * Returns the SMTP user name.
	 * @return the SMTP user name
	 */
	public String getSMTPUser();
	
	/**
	 * Returns the SMTP password. 
	 * @return the SMTP password
	 */
	public String getSMTPPassword();
	
	/**
	 * Returns the sender address used to compose the notifications.
	 * @return the sender address used to compose the notifications
	 */
	public String getSenderAddress();
	
	/**
	 * Returns the template string to generate the notification subject.
	 * @return the template string to generate the notification subject
	 */
	public String getSubjectTemplate();

	/**
	 * Returns the template string to generate the notification body.
	 * @return the template string to generate the notification body
	 */
	public String getBodyTemplate();

}
