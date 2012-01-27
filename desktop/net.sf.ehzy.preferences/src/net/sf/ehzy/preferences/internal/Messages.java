/**
 * Copyright (c) 2012 Volker Wegert and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Volker Wegert - initial API and implementation
 */
package net.sf.ehzy.preferences.internal;

import org.eclipse.osgi.util.NLS;

/**
 * The bundle message accessor.
 * @author vwegert
 */
@SuppressWarnings("javadoc")
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "net.sf.ehzy.preferences.internal.messages"; //$NON-NLS-1$
	public static String MailTemplatePreferencePage_BodyLabel;
	public static String MailTemplatePreferencePage_SenderAddressLabel;
	public static String MailTemplatePreferencePage_SubjectLabel;
	public static String MainPreferencePage_DateFormatLabel;
	public static String MainPreferencePage_ObjectIDLabel;
	public static String MainPreferencePage_SMTPPasswordLabel;
	public static String MainPreferencePage_SMTPPortLabel;
	public static String MainPreferencePage_SMTPServerLabel;
	public static String MainPreferencePage_SMTPUserLabel;
	public static String MainPreferencePage_TotalEnergySuppliedLabel;
	public static String PreferenceInitializer_DefaultDateFormat;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
