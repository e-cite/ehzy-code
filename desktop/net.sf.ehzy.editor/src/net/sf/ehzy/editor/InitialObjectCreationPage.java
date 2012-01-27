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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * This is the page where the type of object to create is selected.
 */
public class InitialObjectCreationPage extends WizardPage {

	private Text fileField;
	private List<String> encodings;
	private Combo encodingField;

	/**
	 * Tracks the changes in the page.
	 */
	protected ModifyListener validator =
			new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			setPageComplete(validatePage());
		}
	};

	/**
	 * Default constructor.
	 * @param pageId 
	 */
	public InitialObjectCreationPage(String pageId) {
		super(pageId);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}

		Label resourceURILabel = new Label(composite, SWT.LEFT);
		{
			resourceURILabel.setText(Messages.InitialObjectCreationPage_FileLabel);

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			resourceURILabel.setLayoutData(data);
		}

		Composite fileComposite = new Composite(composite, SWT.NONE);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.END;
			fileComposite.setLayoutData(data);

			GridLayout layout = new GridLayout();
			data.horizontalAlignment = GridData.FILL;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.numColumns = 2;
			fileComposite.setLayout(layout);
		}

		fileField = new Text(fileComposite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			data.horizontalSpan = 1;
			fileField.setLayoutData(data);
		}

		fileField.addModifyListener(validator);

		Button resourceURIBrowseFileSystemButton = new Button(fileComposite, SWT.PUSH);
		resourceURIBrowseFileSystemButton.setText(Messages.InitialObjectCreationPage_BrowseButton);

		resourceURIBrowseFileSystemButton.addSelectionListener
		(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				String[] filters = ModelEditor.FILE_EXTENSION_FILTERS.toArray(new String[ModelEditor.FILE_EXTENSION_FILTERS.size()]);
				String[] files = EHZyEditorAdvisor.openFilePathDialog(getShell(), SWT.SAVE, filters);
				if (files.length > 0) {
					fileField.setText(files[0]);
				}
			}
		});
		Label encodingLabel = new Label(composite, SWT.LEFT);
		{
			encodingLabel.setText(Messages.InitialObjectCreationPage_EncodingLabel);

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			encodingLabel.setLayoutData(data);
		}
		encodingField = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			encodingField.setLayoutData(data);
		}

		for (String encoding : getEncodings()) {
			encodingField.add(encoding);
		}

		encodingField.select(0);
		encodingField.addModifyListener(validator);

		setPageComplete(validatePage());
		setControl(composite);
	}


	/**
	 * Checks whether the page is filled out correctly.
	 * @return <code>true</code> if the values on the page can be used.
	 */
	protected boolean validatePage() {
		URI fileURI = getFileURI();
		if (fileURI == null || fileURI.isEmpty()) {
			setErrorMessage(null);
			return false;
		}

		String extension = fileURI.fileExtension();
		if (extension == null || !EHZyModelWizard.FILE_EXTENSIONS.contains(extension)) {
			setErrorMessage(MessageFormat.format(Messages.InitialObjectCreationPage_FileExtensionErrorMessage, EHZyModelWizard.FORMATTED_FILE_EXTENSIONS));
			return false;
		}

		setErrorMessage(null);
		return getEncodings().contains(encodingField.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			encodingField.clearSelection();
			fileField.setFocus();
		}
	}

	/**
	 * Returns the encoding selected.
	 * @return the encoding selected
	 */
	public String getEncoding() {
		return encodingField.getText();
	}

	/**
	 * Returns the file UrI specified.
	 * @return the file UrI specified
	 */
	public URI getFileURI() {
		try {
			return URI.createFileURI(fileField.getText());
		}
		catch (Exception exception) {
			// Ignore
		}
		return null;
	}

	/**
	 * Activates the file name field.
	 */
	public void selectFileField() {
		encodingField.clearSelection();
		fileField.selectAll();
		fileField.setFocus();
	}		

	/**
	 * Returns the list of supported encodings.
	 * @return the list of supported encodings
	 */
	protected Collection<String> getEncodings() {
		if (encodings == null) {
			encodings = new ArrayList<String>();
			for (StringTokenizer stringTokenizer = new StringTokenizer(EHZyEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens(); ) { //$NON-NLS-1$
				encodings.add(stringTokenizer.nextToken());
			}
		}
		return encodings;
	}
}