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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class initializes the preferences with some (hopefully) sensible default values.
 * @author vwegert
 *
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Default constructor.
	 */
	public PreferenceInitializer() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getInstance().getPreferenceStore();
		
		store.setDefault(PreferenceConstants.DATE_FORMAT, Messages.PreferenceInitializer_DefaultDateFormat); // TODO externalize this
		store.setDefault(PreferenceConstants.VALUE_OBJECT_ID, "0100010800FF"); //$NON-NLS-1$
		
		store.setDefault(PreferenceConstants.SMTP_PORT, 25);
		
//		store.setDefault(PreferenceConstants.SUBJECT_TEMPLATE, ""); // TODO add mail subject template to PreferenceInitializer
//		store.setDefault(PreferenceConstants.BODY_TEMPLATE, "");    // TODO add mail body template to PreferenceInitializer
	}

}
