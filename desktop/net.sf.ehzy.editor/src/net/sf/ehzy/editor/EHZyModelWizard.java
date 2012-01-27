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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehzy.model.ModelFactory;
import net.sf.ehzy.model.ModelPackage;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;


/**
 * This is a simple wizard for creating a new model file.
 */
public class EHZyModelWizard extends Wizard implements INewWizard {

	/**
	 * The supported extensions for created files.
	 */
	public static final List<String> FILE_EXTENSIONS =
			Collections.unmodifiableList(Arrays.asList(EHZyEditorPlugin.INSTANCE.getString("_UI_ModelEditorFilenameExtensions").split("\\s*,\\s*"))); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * A formatted list of supported file extensions, suitable for display.
	 */
	public static final String FORMATTED_FILE_EXTENSIONS =
			EHZyEditorPlugin.INSTANCE.getString("_UI_ModelEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	/**
	 * This caches an instance of the model package.
	 */
	protected ModelPackage modelPackage = ModelPackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory.
	 */
	protected ModelFactory modelFactory = modelPackage.getModelFactory();

	/**
	 * This is the initial object creation page.
	 */
	protected InitialObjectCreationPage initialObjectCreationPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 */
	protected IWorkbench workbench;

	/**
	 * This just records the information.
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.EHZyModelWizard_WindowTitle);
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(EHZyEditorPlugin.INSTANCE.getImage("full/wizban/NewModel"))); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		try {
			// Get the URI of the model file.
			//
			final URI fileURI = getModelURI();
			if (new File(fileURI.toFileString()).exists()) {
				if (!MessageDialog.openQuestion
						(getShell(), Messages.EHZyModelWizard_QuestionDialogTitle,
								MessageFormat.format(Messages.EHZyModelWizard_OverwriteFileConfirmationText, 
										fileURI.toFileString() ))) {
					initialObjectCreationPage.selectFileField();
					return false;
				}
			}

			// Do the work within an operation.
			IRunnableWithProgress operation = new IRunnableWithProgress() {
				public void run(IProgressMonitor progressMonitor) {
					try {
						// Create a resource set
						ResourceSet resourceSet = new ResourceSetImpl();

						// Create a resource for this file.
						Resource resource = resourceSet.createResource(fileURI);
						EObject rootObject1 = modelFactory.createProject();

						// Add the initial model object to the contents.
						EObject rootObject = rootObject1;
						if (rootObject != null) {
							resource.getContents().add(rootObject);
						}

						// Save the contents of the resource to the file system.
						Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
						resource.save(options);
					}
					catch (Exception exception) {
						EHZyEditorPlugin.INSTANCE.log(exception);
					}
					finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			return EHZyEditorAdvisor.openEditor(workbench, fileURI);			
		}
		catch (Exception exception) {
			EHZyEditorPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		initialObjectCreationPage = new InitialObjectCreationPage("Whatever2"); //$NON-NLS-1$
		initialObjectCreationPage.setTitle(Messages.EHZyModelWizard_CreationPageTitle);
		initialObjectCreationPage.setDescription(Messages.EHZyModelWizard_CreationPageDescription);
		addPage(initialObjectCreationPage);
	}

	/**
	 * Get the URI from the page.
	 * @return the URI from the page
	 */
	public URI getModelURI() {
		return initialObjectCreationPage.getFileURI();
	}

}
