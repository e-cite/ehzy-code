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

import net.sf.ehzy.preferences.Activator;
import net.sf.ehzy.preferences.IPreferences;

/**
 * The actual implementation of the {@link IPreferences} service definition.
 * @author vwegert
 *
 */
public class PreferencesImpl implements IPreferences {

	/* (non-Javadoc)
	 * @see net.sf.ehzy.preferences.IPreferences#getDateFormat()
	 */
	@Override
	public String getDateFormat() {
		return Activator.getInstance().getPreferenceStore().getString(PreferenceConstants.DATE_FORMAT);
	}

	/* (non-Javadoc)
	 * @see net.sf.ehzy.preferences.IPreferences#getValueObjectID()
	 */
	@Override
	public String getValueObjectID() {
		return Activator.getInstance().getPreferenceStore().getString(PreferenceConstants.VALUE_OBJECT_ID);
	}

	/* (non-Javadoc)
	 * @see net.sf.ehzy.preferences.IPreferences#getSMTPServer()
	 */
	@Override
	public String getSMTPServer() {
		return Activator.getInstance().getPreferenceStore().getString(PreferenceConstants.SMTP_SERVER);
	}

	/* (non-Javadoc)
	 * @see net.sf.ehzy.preferences.IPreferences#getSMTPPort()
	 */
	@Override
	public int getSMTPPort() {
		return Activator.getInstance().getPreferenceStore().getInt(PreferenceConstants.SMTP_PORT);
	}

	/* (non-Javadoc)
	 * @see net.sf.ehzy.preferences.IPreferences#getSMTPUser()
	 */
	@Override
	public String getSMTPUser() {
		return Activator.getInstance().getPreferenceStore().getString(PreferenceConstants.SMTP_USER);
	}

	/* (non-Javadoc)
	 * @see net.sf.ehzy.preferences.IPreferences#getSMTPPassword()
	 */
	@Override
	public String getSMTPPassword() {
		return Activator.getInstance().getPreferenceStore().getString(PreferenceConstants.SMTP_PASSWORD);
	}

	/* (non-Javadoc)
	 * @see net.sf.ehzy.preferences.IPreferences#getSenderAddress()
	 */
	@Override
	public String getSenderAddress() {
		return Activator.getInstance().getPreferenceStore().getString(PreferenceConstants.SENDER_ADDRESS);
	}

	/* (non-Javadoc)
	 * @see net.sf.ehzy.preferences.IPreferences#getSubjectTemplate()
	 */
	@Override
	public String getSubjectTemplate() {
		return Activator.getInstance().getPreferenceStore().getString(PreferenceConstants.SUBJECT_TEMPLATE);
	}

	/* (non-Javadoc)
	 * @see net.sf.ehzy.preferences.IPreferences#getBodyTemplate()
	 */
	@Override
	public String getBodyTemplate() {
		return Activator.getInstance().getPreferenceStore().getString(PreferenceConstants.BODY_TEMPLATE);
	}

}
