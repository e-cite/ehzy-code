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
package net.sf.ehzy.editor;

import org.eclipse.osgi.util.NLS;

/**
 * The bundle message accessor.
 * @author vwegert
 */
@SuppressWarnings("javadoc")
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "net.sf.ehzy.editor.messages"; //$NON-NLS-1$
	public static String AboutAction_AboutBoxText;
	public static String AboutAction_AboutBoxTitle;
	public static String EHZyEditorAdvisor_ErrorDialogTitle;
	public static String EHZyEditorAdvisor_NoEditorRegisteredErrorMessage;
	public static String EHZyEditorAdvisor_OpenErrorDialogTitle;
	public static String EHZyModelWizard_CreationPageDescription;
	public static String EHZyModelWizard_CreationPageTitle;
	public static String EHZyModelWizard_OverwriteFileConfirmationText;
	public static String EHZyModelWizard_QuestionDialogTitle;
	public static String EHZyModelWizard_WindowTitle;
	public static String ImportSMLHandler_CompletionMessage;
	public static String ImportSMLHandler_DecodeError;
	public static String ImportSMLHandler_FatalErrorMessage;
	public static String ImportSMLHandler_FileMessagePattern;
	public static String ImportSMLHandler_FileValueCountMessage;
	public static String ImportSMLHandler_InvalidUnitError;
	public static String ImportSMLHandler_MainProgressMessage;
	public static String ImportSMLHandler_MessageDialogTitle;
	public static String ImportSMLHandler_NoFileOpenMessage;
	public static String ImportSMLHandler_NoProjectMessage;
	public static String ImportSMLHandler_ReadoutDateError;
	public static String ImportSMLHandler_ReadoutDatePrompt;
	public static String ImportSMLHandler_TypeConversionError;
	public static String ImportSMLHandler_ValueMessage;
	public static String InitialObjectCreationPage_BrowseButton;
	public static String InitialObjectCreationPage_EncodingLabel;
	public static String InitialObjectCreationPage_FileExtensionErrorMessage;
	public static String InitialObjectCreationPage_FileLabel;
	public static String ModelActionBarContributor_MenuContributionLabel;
	public static String ModelActionBarContributor_NewChildLabel;
	public static String ModelActionBarContributor_NewSiblingLabel;
	public static String ModelActionBarContributor_RefreshActionLabel;
	public static String ModelActionBarContributor_ShowPropertiesViewActionLabel;
	public static String ModelEditor_EmptySelectionLabel;
	public static String ModelEditor_FileConflictDialogMessage;
	public static String ModelEditor_FileConflictDialogTitle;
	public static String ModelEditor_FileContentsErrorTemplate;
	public static String ModelEditor_MultiSelectionLabel;
	public static String ModelEditor_PageDescription;
	public static String ModelEditor_SingleSelectionLabel;
	public static String PendingNotificationsView_LastMessageColumnLabel;
	public static String PendingNotificationsView_LastReadoutColumnLabel;
	public static String PendingNotificationsView_LocationColumnLabel;
	public static String PendingNotificationsView_RecipientColumnLabel;
	public static String SendMessageHandler_ConfirmationPrompt;
	public static String SendMessageHandler_DetailsHint;
	public static String SendMessageHandler_ErrorMessage;
	public static String SendMessageHandler_MessageWindowTitle;
	public static String SendMessageHandler_OverallErrorMessage;
	public static String WindowActionBarAdvisor_EditMenuText;
	public static String WindowActionBarAdvisor_FileMenuText;
	public static String WindowActionBarAdvisor_HelpMenuText;
	public static String WindowActionBarAdvisor_WindowMenuText;
	public static String WindowAdvisor_WindowTitle;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
