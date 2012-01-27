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

import java.io.File;
import java.text.MessageFormat;
import java.util.Arrays;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * Customized {@link WorkbenchAdvisor} for the RCP application.
 */
public final class EHZyEditorAdvisor extends WorkbenchAdvisor {

	/**
	 * The default file extension filters for use in dialogs.
	 */
	private static final String[] FILE_EXTENSION_FILTERS = ModelEditor.FILE_EXTENSION_FILTERS.toArray(new String[0]); 

	/**
	 * Auxiliary method to show a File Open dialog.
	 * @param shell 
	 * @param style 
	 * @param fileExtensionFilters 
	 * @return the selected files 
	 */
	public static String[] openFilePathDialog(Shell shell, int style, String[] fileExtensionFilters) {
		return openFilePathDialog(shell, style, fileExtensionFilters, (style & SWT.OPEN) != 0, (style & SWT.OPEN) != 0, (style & SWT.SAVE) != 0);
	}

	/**
	 * Auxiliary method to show a File Open dialog.
	 * @param shell 
	 * @param style 
	 * @param fileExtensionFilters 
	 * @param includeGroupFilter 
	 * @param includeAllFilter 
	 * @param addExtension 
	 * @return the selected files
	 */
	public static String[] openFilePathDialog(Shell shell, int style, String[] fileExtensionFilters, boolean includeGroupFilter, boolean includeAllFilter, boolean addExtension) {
		FileDialog fileDialog = new FileDialog(shell, style);
		if (fileExtensionFilters == null) {
			fileExtensionFilters = FILE_EXTENSION_FILTERS;
		}

		// If requested, augment the file extension filters by adding a group of all the other filters (*.ext1;*.ext2;...)
		// at the beginning and/or an all files wildcard (*.*) at the end.
		includeGroupFilter &= fileExtensionFilters.length > 1;
		int offset = includeGroupFilter ? 1 : 0;

		if (includeGroupFilter || includeAllFilter) {
			int size = fileExtensionFilters.length + offset + (includeAllFilter ? 1 : 0);
			String[] allFilters = new String[size];
			StringBuilder group = includeGroupFilter ? new StringBuilder() : null;

			for (int i = 0; i < fileExtensionFilters.length; i++) {
				if (includeGroupFilter) {
					if (i != 0) {
						group.append(';');
					}
					group.append(fileExtensionFilters[i]);
				}
				allFilters[i + offset] = fileExtensionFilters[i];
			}

			if (includeGroupFilter) {
				allFilters[0] = group.toString();
			}
			if (includeAllFilter) {
				allFilters[allFilters.length - 1] = "*.*"; //$NON-NLS-1$
			}

			fileDialog.setFilterExtensions(allFilters);
		}
		else {
			fileDialog.setFilterExtensions(fileExtensionFilters);
		}
		fileDialog.open();

		String[] filenames = fileDialog.getFileNames();
		String[] result = new String[filenames.length];
		String path = fileDialog.getFilterPath() + File.separator;
		String extension = null;

		// If extension adding requested, get the dotted extension corresponding to the selected filter.
		if (addExtension) {
			int i = fileDialog.getFilterIndex();
			if (i != -1 && (!includeAllFilter || i != fileExtensionFilters.length)) {
				i = includeGroupFilter && i == 0 ? 0 : i - offset;
				String filter = fileExtensionFilters[i];
				int dot = filter.lastIndexOf('.');
				if (dot == 1 && filter.charAt(0) == '*') {
					extension = filter.substring(dot);
				}
			}
		}

		// Build the result by adding the selected path and, if needed, auto-appending the extension.
		for (int i = 0; i < filenames.length; i++) {
			String filename = path + filenames[i];
			if (extension != null) {
				int dot = filename.lastIndexOf('.');
				if (dot == -1 || !Arrays.asList(fileExtensionFilters).contains("*" + filename.substring(dot))) { //$NON-NLS-1$
					filename += extension;
				}
			}
			result[i] = filename;
		}
		return result;
	}

	/**
	 * Opens an editor for the selected file.
	 * @param workbench 
	 * @param uri 
	 * @return <code>true</code> if the editor was opened.
	 */
	public static boolean openEditor(IWorkbench workbench, URI uri) {
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = workbenchWindow.getActivePage();

		IEditorDescriptor editorDescriptor = EditUIUtil.getDefaultEditor(uri, null);
		if (editorDescriptor == null) {
			MessageDialog.openError(
					workbenchWindow.getShell(),
					Messages.EHZyEditorAdvisor_ErrorDialogTitle,
					MessageFormat.format(Messages.EHZyEditorAdvisor_NoEditorRegisteredErrorMessage, uri.lastSegment()));
			return false;
		}
		else {
			try {
				page.openEditor(new URIEditorInput(uri), editorDescriptor.getId());
			}
			catch (PartInitException exception) {
				MessageDialog.openError(
						workbenchWindow.getShell(), Messages.EHZyEditorAdvisor_OpenErrorDialogTitle,
						exception.getMessage());
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId()
	 */
	@Override
	public String getInitialWindowPerspectiveId() {
		return Perspective.ID_PERSPECTIVE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#initialize(org.eclipse.ui.application.IWorkbenchConfigurer)
	 */
	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);
		configurer.setSaveAndRestore(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#createWorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchWindowConfigurer)
	 */
	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new WindowAdvisor(configurer);
	}
}
