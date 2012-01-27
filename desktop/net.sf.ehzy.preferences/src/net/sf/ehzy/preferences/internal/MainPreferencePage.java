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

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * The main preference page, containing all but the message template settings.
 */
public class MainPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Default constructor.
	 */
	public MainPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getInstance().getPreferenceStore());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	public void createFieldEditors() {
		
		addField(new StringFieldEditor(PreferenceConstants.DATE_FORMAT, 
				Messages.MainPreferencePage_DateFormatLabel, getFieldEditorParent()));
		
		String objectIDs[][] = { { Messages.MainPreferencePage_TotalEnergySuppliedLabel, "01-00-01-08-00-FF" } }; //$NON-NLS-2$
		// TODO Add other OBIS IDs here.
		addField(new ComboFieldEditor(PreferenceConstants.VALUE_OBJECT_ID, 
				Messages.MainPreferencePage_ObjectIDLabel, objectIDs, getFieldEditorParent()));
		
		addField(new StringFieldEditor(PreferenceConstants.SMTP_SERVER, 
				Messages.MainPreferencePage_SMTPServerLabel, getFieldEditorParent()));
		addField(new IntegerFieldEditor(PreferenceConstants.SMTP_PORT, 
				Messages.MainPreferencePage_SMTPPortLabel, getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceConstants.SMTP_USER, 
				Messages.MainPreferencePage_SMTPUserLabel, getFieldEditorParent()));
		StringFieldEditor passwordEditor = new StringFieldEditor(PreferenceConstants.SMTP_PASSWORD, 
				Messages.MainPreferencePage_SMTPPasswordLabel, getFieldEditorParent());
		passwordEditor.getTextControl(getFieldEditorParent()).setEchoChar('*');
		addField(passwordEditor);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		// not required
	}
	
}