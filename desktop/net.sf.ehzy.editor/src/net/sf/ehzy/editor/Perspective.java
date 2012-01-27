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

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * The perspective.
 */
public class Perspective implements IPerspectiveFactory {
	
	/**
	 * The perspective ID as specified in the plugin definition.
	 */
	public static final String ID_PERSPECTIVE = "net.sf.ehzy.editor.Perspective"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.addPerspectiveShortcut(ID_PERSPECTIVE);

		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, (float)0.66, layout.getEditorArea()); //$NON-NLS-1$
		right.addView(IPageLayout.ID_PROP_SHEET);
		layout.getViewLayout(IPageLayout.ID_PROP_SHEET).setCloseable(false); 

		IFolderLayout bottonRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, (float)0.60, "right"); //$NON-NLS-1$ //$NON-NLS-2$
		bottonRight.addView(PendingNotificationsView.ID);
		layout.getViewLayout(PendingNotificationsView.ID).setCloseable(false); 
	}
}