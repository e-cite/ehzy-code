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

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This page displays the notification templates.
 */
public class MailTemplatePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Default constructor.
	 */
	public MailTemplatePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getInstance().getPreferenceStore());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	public void createFieldEditors() {
		addField(new StringFieldEditor(PreferenceConstants.SENDER_ADDRESS,
				Messages.MailTemplatePreferencePage_SenderAddressLabel, getFieldEditorParent()));
		
		addField(new StringFieldEditor(PreferenceConstants.SUBJECT_TEMPLATE,
				Messages.MailTemplatePreferencePage_SubjectLabel, getFieldEditorParent()));
		
		addField(new MultilineFieldEditor(PreferenceConstants.BODY_TEMPLATE,
				Messages.MailTemplatePreferencePage_BodyLabel, getFieldEditorParent()));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		// not required
	}
	
}