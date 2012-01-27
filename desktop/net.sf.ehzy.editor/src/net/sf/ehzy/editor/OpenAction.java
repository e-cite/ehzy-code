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
package net.sf.ehzy.editor;

import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;

/**
 * Open action for the objects from the EHZy model.
 */
public class OpenAction extends WorkbenchWindowActionDelegate {

	/**
	 * Opens the editors for the files selected using the file dialog.
	 */
	public void run(IAction action) {
		String[] filePaths = EHZyEditorAdvisor.openFilePathDialog(getWindow().getShell(), SWT.OPEN, null);
		if (filePaths.length > 0) {
			EHZyEditorAdvisor.openEditor(getWindow().getWorkbench(), URI.createFileURI(filePaths[0]));
		}
	}
}