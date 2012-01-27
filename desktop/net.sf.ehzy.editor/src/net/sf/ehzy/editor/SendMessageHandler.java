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
/**
 * 
 */
package net.sf.ehzy.editor;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.ehzy.model.ModelPackage;
import net.sf.ehzy.model.Recipient;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * The command handler to send mails to recipients containing the current readout data.
 * @see MailGenerator
 * @author vwegert
 *
 */
public class SendMessageHandler extends AbstractHandler {

	/**
	 * The command ID as specified in the plugin definition.
	 */
	public static final String COMMAND_ID = "net.sf.ehzy.editor.SendMessageCommand"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MailGenerator generator = new MailGenerator();
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
		if (MessageDialog.openConfirm(HandlerUtil.getActiveShellChecked(event), Messages.SendMessageHandler_MessageWindowTitle, 
				MessageFormat.format(Messages.SendMessageHandler_ConfirmationPrompt,	selection.size()))) {
			List<IStatus> statuses = new ArrayList<IStatus>();
			for (Iterator<?> iterator = selection.iterator(); iterator.hasNext();) {
				Recipient rec = (Recipient)iterator.next();
				try {
					// end the mail
					generator.sendMail(rec);
					// and record the send date
					EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(rec);
					editingDomain.getCommandStack().execute(new SetCommand(editingDomain, rec, 
							ModelPackage.Literals.RECIPIENT__LAST_MESSAGE_DATE, new Date()));
				} catch (Throwable t) {
					statuses.add(new Status(IStatus.ERROR, EHZyEditorPlugin.PLUGIN_ID, 
							MessageFormat.format(
									Messages.SendMessageHandler_ErrorMessage,
									rec.getName(), t.getLocalizedMessage()), t));
				}
			}
			if (statuses.size() > 0) {
				MultiStatus multiStatus = new MultiStatus(EHZyEditorPlugin.PLUGIN_ID, 0, 
						statuses.toArray(new IStatus[statuses.size()]), 
						Messages.SendMessageHandler_DetailsHint, null);
				ErrorDialog.openError(HandlerUtil.getActiveShellChecked(event), Messages.SendMessageHandler_MessageWindowTitle, 
						Messages.SendMessageHandler_OverallErrorMessage, multiStatus);
			}
		}
		return null;
	}

}
