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
import java.util.Iterator;
import java.util.List;

import net.sf.ehzy.model.ModelPackage;
import net.sf.ehzy.model.Readout;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * The command handler remove readout objects that are past their expiration date.
 * @author vwegert
 *
 */
public class ExpireReadoutsHandler extends AbstractHandler {

	/**
	 * The command ID as specified in the plugin definition.
	 */
	public static final String COMMAND_ID = "net.sf.ehzy.editor.ExpireReadoutsCommand"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shell activeShell = HandlerUtil.getActiveShellChecked(event);

		// check editor type
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if ((editor == null) || !(editor instanceof ModelEditor)) {
			MessageDialog.openError(activeShell, Messages.ExpireReadoutsHandler_MessageDialogTitle, 
					Messages.ExpireReadoutsHandler_NoModelEditorMessage);
		} else {

			// find all expired readout objects in and below the current selection
			IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
			List<Readout> expiredReadouts = new ArrayList<Readout>();
			for (Iterator<?> iterator = selection.iterator(); iterator.hasNext();) {
				EObject obj = (EObject) iterator.next();
				if (obj instanceof Readout) {
					if (((Readout)obj).isExpired()) {
						expiredReadouts.add((Readout) obj);
					}
				}
				for (TreeIterator<EObject> itChildren = obj.eAllContents(); itChildren.hasNext();) {
					EObject child = itChildren.next();
					if (child instanceof Readout) {
						if (((Readout)child).isExpired()) {
							expiredReadouts.add((Readout) child);
						}
					}
				}
			}

			if (expiredReadouts.isEmpty()) {
				StatusManager.getManager().handle(new Status(IStatus.INFO, EHZyEditorPlugin.PLUGIN_ID, 
						Messages.ExpireReadoutsHandler_NoReadoutsFoundMessage), StatusManager.SHOW);
			} else {
				if (MessageDialog.openQuestion(activeShell, Messages.ExpireReadoutsHandler_MessageDialogTitle, 
						MessageFormat.format(Messages.ExpireReadoutsHandler_ExpirationConfirmationPrompt,
								expiredReadouts.size()))) {
					for (Readout r: expiredReadouts) {
						EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(r);
						editingDomain.getCommandStack().execute(
								RemoveCommand.create(editingDomain, r.getMeter(), ModelPackage.Literals.METER__READOUTS, r));
					}
					((ModelEditor)editor).refresh();
				}
			}
		}
		return null;
	}

}
