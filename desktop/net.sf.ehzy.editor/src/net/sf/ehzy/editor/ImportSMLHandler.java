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

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.ehzy.model.Location;
import net.sf.ehzy.model.Meter;
import net.sf.ehzy.model.ModelFactory;
import net.sf.ehzy.model.ModelPackage;
import net.sf.ehzy.model.Project;
import net.sf.ehzy.model.Readout;
import net.sf.ehzy.preferences.IPreferences;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.openmuc.jsml.structures.ASNObject;
import org.openmuc.jsml.structures.Integer16;
import org.openmuc.jsml.structures.Integer32;
import org.openmuc.jsml.structures.Integer64;
import org.openmuc.jsml.structures.Integer8;
import org.openmuc.jsml.structures.SML_File;
import org.openmuc.jsml.structures.SML_GetListRes;
import org.openmuc.jsml.structures.SML_ListEntry;
import org.openmuc.jsml.structures.SML_Message;
import org.openmuc.jsml.structures.SML_MessageBody;
import org.openmuc.jsml.structures.SML_Unit;
import org.openmuc.jsml.structures.Unsigned16;
import org.openmuc.jsml.structures.Unsigned32;
import org.openmuc.jsml.structures.Unsigned64;
import org.openmuc.jsml.structures.Unsigned8;
import org.openmuc.jsml.tl.SMLMessageExtractor;

/**
 * Command handler to import SML files and add them to the model.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ImportSMLHandler extends AbstractHandler {

	/**
	 * The Runnable that actually performs the import.
	 * @author vwegert
	 */
	private class ImportSMLRunnable implements IRunnableWithProgress {

		private Project project;
		private String basePath;
		private String fileNames[];
		private Date readoutDate;
		private MultiStatus multiStatus;

		/**
		 * Default constructor.
		 * @param project
		 * @param basePath
		 * @param fileNames
		 * @param readoutDate
		 */
		public ImportSMLRunnable(Project project, String basePath, String[] fileNames, Date readoutDate) {
			super();
			this.project = project;
			this.basePath = basePath;
			this.fileNames = fileNames;
			this.readoutDate = readoutDate;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
		 */
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			IStatus statuses[] = new IStatus[fileNames.length];
			int i = 0;
			monitor.beginTask(Messages.ImportSMLHandler_MainProgressMessage, fileNames.length);
			for (final String fileName: fileNames) {
				monitor.subTask(fileName);
				try {
					statuses[i] = importFile(fileName);
				} catch (Throwable t) {
					statuses[i] = new Status(IStatus.ERROR, EHZyEditorPlugin.PLUGIN_ID, MessageFormat.format(Messages.ImportSMLHandler_FileMessagePattern, fileName, t.getLocalizedMessage()));
				} finally {
					i++;
					monitor.worked(1);
				}
			}
			multiStatus = new MultiStatus(EHZyEditorPlugin.PLUGIN_ID, 0, statuses, Messages.ImportSMLHandler_CompletionMessage, null);
			monitor.done();
		}

		/**
		 * Returns the status of the operation
		 * @return the status of the operation
		 */
		public IStatus getStatus() {
			return multiStatus;
		}

		/**
		 * Imports a single file.
		 * @param fileName
		 * @return the result
		 * @throws IOException 
		 */
		protected IStatus importFile(String fileName) throws IOException {
			List<IStatus> statuses = new ArrayList<IStatus>();
			byte[] msg;
			SML_File smlFile;

			// parse the input file
			DataInputStream dis = new DataInputStream(new FileInputStream(basePath + "/" + fileName)); // TODO use platform-specific delimiter here? //$NON-NLS-1$
			SMLMessageExtractor extractor = new SMLMessageExtractor(dis, 100);
			msg = extractor.getSmlMessage();
			DataInputStream mis = new DataInputStream(new ByteArrayInputStream(msg));
			smlFile = new SML_File();
			while (mis.available() > 0) {
				SML_Message message = new SML_Message();
				if (!message.decode(mis)) {
					throw new IOException(Messages.ImportSMLHandler_DecodeError);
				} else {
					smlFile.add(message);
				}
			}

			// parse the messages in the file and look for a GetListResponse message
			for (SML_Message message: smlFile.getMessages()) {
				SML_MessageBody body = message.getMessageBody();
				if (body.getTag().getVal() == SML_MessageBody.GetListResponse) {
					SML_GetListRes getListRes = (SML_GetListRes) body.getChoice();
					
					// read the meter ID
					final String meterID = HexUtil.toHexString(getListRes.getServerId().getOctetString(), 2);

					// find the meter object corresponding to the meter ID
					Meter meter = getMeterObject(meterID);
					EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(meter);

					// create and fill a new readout object
					Readout readout = createReadoutObject(msg, getListRes);
					
					// check whether a readout object is already present for the date - if it is, remove it
					for (Readout r: meter.getReadouts()) {
						if (r.getDate().equals(readout.getDate())) {
							editingDomain.getCommandStack().execute(RemoveCommand.create(editingDomain, r));
						}
					}
					
					// add the new readout to the meter object
					editingDomain.getCommandStack().execute(AddCommand.create(editingDomain, meter, 
							ModelPackage.Literals.METER__READOUTS, readout));
					
					// record the success
					statuses.add(new Status(IStatus.OK, EHZyEditorPlugin.PLUGIN_ID, 
							MessageFormat.format(Messages.ImportSMLHandler_ValueMessage, meter.getDeviceID(),
							readout.getTotalConsumption().toPlainString())));
				}
			}

			return new MultiStatus(EHZyEditorPlugin.PLUGIN_ID, 0, statuses.toArray(new IStatus[statuses.size()]), 
					MessageFormat.format(Messages.ImportSMLHandler_FileValueCountMessage, fileName,
					statuses.size()), null);

		}

		/**
		 * Creates a new {@link Readout} object and parses the message into it.
		 * @param messageContents
		 * @param getListResMessage
		 * @return the newly created object
		 */
		private Readout createReadoutObject(byte[] messageContents, SML_GetListRes getListResMessage) {
			Readout readout = ModelFactory.eINSTANCE.createReadout();
			readout.setMessageContents(messageContents);
			readout.setDate(readoutDate);
			for (SML_ListEntry entry: getListResMessage.getValList().getValListEntry()) {
				final String objectID = HexUtil.toHexString(entry.getObjName().getOctetString());
				if (objectID.equals(valueObjectID)) { 
					BigDecimal value = convertValueToBigDecimal(entry.getValue().getChoice());
					BigDecimal unitScaler = null;
					if (entry.getUnit().getVal() == SML_Unit.WATT_HOUR) {
						unitScaler = new BigDecimal(1000);
					} else {
						throw new UnsupportedOperationException(MessageFormat
								.format(Messages.ImportSMLHandler_InvalidUnitError,
										entry.getUnit().getVal()));
					}
					BigDecimal scaler = new BigDecimal(10).pow(Math.abs(entry.getScaler().getVal()));
					BigDecimal kwh = null;
					if (entry.getScaler().getVal() < 0) {
						kwh = value.divide(scaler).divide(unitScaler);
					} else {
						kwh = value.multiply(scaler).divide(unitScaler);
					}
					readout.setTotalConsumption(kwh.setScale(4, RoundingMode.HALF_UP));
				}
			}
			
			return readout;
		}

		/**
		 * Converts an {@link ASNObject} to a {@link BigDecimal} if possible.
		 * @param val
		 * @return the result of the conversion
		 */
		private BigDecimal convertValueToBigDecimal(ASNObject val) {
			BigDecimal value = null;
			if (val instanceof Integer64) {
				value = new BigDecimal(((Integer64) val).getVal());
			} else if (val instanceof Integer32) {
				value = new BigDecimal(((Integer32) val).getVal());
			} else if (val instanceof Integer16) {
				value = new BigDecimal(((Integer32) val).getVal());
			} else if (val instanceof Integer8) {
				value = new BigDecimal(((Integer32) val).getVal());
			} else if (val instanceof Unsigned64) {
				value = new BigDecimal(((Unsigned64) val).getVal());
			} else if (val instanceof Unsigned32) {
				value = new BigDecimal(((Unsigned32) val).getVal());
			} else if (val instanceof Unsigned16) {
				value = new BigDecimal(((Unsigned32) val).getVal());
			} else if (val instanceof Unsigned8) {
				value = new BigDecimal(((Unsigned32) val).getVal());
			} else {
				throw new UnsupportedOperationException(MessageFormat.format(
						Messages.ImportSMLHandler_TypeConversionError, val.getClass().getName()));
			}
			return value;
		}

		/**
		 * Finds a {@link Meter} object by its ID or creates a new one.
		 * @param meterID
		 * @return the meter object corresponding to that ID
		 */
		private Meter getMeterObject(final String meterID) {
			Meter meter = null;
			for (Location loc: project.getLocations()) {
				for (Meter m: loc.getMeters()) {
					if (m.getDeviceID().equals(meterID)) {
						meter = m;
						break;
					}
				}
			}
			if (meter == null) {
				// meter not found, create new
				// find the default location
				Location location = null;
				for (Location loc: project.getLocations()) {
					if (loc.getName().equals("default")) { // TODO move this to preferences
						location = loc;
						break;
					}
				}
				if (location == null) {
					// location not found, create new one
					location = ModelFactory.eINSTANCE.createLocation();
					location.setName("default"); // TODO move this to preferences (see above)
					project.getLocations().add(location);
				}
				// create meter and add it to location
				meter = ModelFactory.eINSTANCE.createMeter();
				meter.setDeviceID(meterID);
				// TODO use a command here instead of modifying the model directly
				location.getMeters().add(meter);
			}
			return meter;
		}

	}

	private SimpleDateFormat dateFormat;
	private String valueObjectID;

	/**
	 * The constructor.
	 */
	public ImportSMLHandler() {
		IPreferences preferences = EHZyEditorPlugin.INSTANCE.getPreferences();
		dateFormat = new SimpleDateFormat(preferences.getDateFormat());
		valueObjectID = preferences.getValueObjectID();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shell activeShell = HandlerUtil.getActiveShellChecked(event);

		// check editor type
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if ((editor == null) || !(editor instanceof ModelEditor)) {
			MessageDialog.openError(activeShell, Messages.ImportSMLHandler_MessageDialogTitle, Messages.ImportSMLHandler_NoFileOpenMessage);
		} else {
			// get the project reference
			final Project project = ((ModelEditor)editor).getProject();
			if (project == null) {
				MessageDialog.openError(activeShell, Messages.ImportSMLHandler_MessageDialogTitle, Messages.ImportSMLHandler_NoProjectMessage);
			} else {
				// ask for a readout date and time
				final Date readoutDate = getReadoutDate(activeShell);
				if (readoutDate == null) {
					return null;
				}

				// ask for the files to import
				FileDialog fileDialog = new FileDialog(activeShell, SWT.OPEN | SWT.MULTI);
				if (fileDialog.open() != null) {
					ImportSMLRunnable runnable = new ImportSMLRunnable(project, fileDialog.getFilterPath(), 
							fileDialog.getFileNames(), readoutDate);
					try {
						new ProgressMonitorDialog(activeShell).run(true, true, runnable);
						((ModelEditor)editor).refresh();
						runnable.getStatus();
						IStatus status = runnable.getStatus();
						StatusManager.getManager().handle(status, StatusManager.SHOW);
					} catch (InvocationTargetException e) {
						ErrorDialog.openError(activeShell, Messages.ImportSMLHandler_MessageDialogTitle, Messages.ImportSMLHandler_FatalErrorMessage, 
								new Status(IStatus.ERROR, EHZyEditorPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));							
					} catch (InterruptedException e) {
						ErrorDialog.openError(activeShell, Messages.ImportSMLHandler_MessageDialogTitle, Messages.ImportSMLHandler_FatalErrorMessage, 
								new Status(IStatus.ERROR, EHZyEditorPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));							
					}
				}
			}
		}

		return null;
	}

	/**
	 * Opens a dialog to enter the readout date and time.
	 * @param activeShell
	 * @return
	 */
	private Date getReadoutDate(final Shell activeShell) {
		InputDialog inputDialog = new InputDialog(activeShell, Messages.ImportSMLHandler_MessageDialogTitle, 
				Messages.ImportSMLHandler_ReadoutDatePrompt, dateFormat.format(new Date()), 
				new IInputValidator() {
			@Override
			public String isValid(String newText) {
				if ((newText == null) || (newText.length() ==0)) {
					return Messages.ImportSMLHandler_ReadoutDateError;
				}
				try {
					dateFormat.parse(newText);
					return null;
				} catch (ParseException e) {
					return e.getLocalizedMessage();
				}
			}
		});
		if (inputDialog.open() != InputDialog.OK) {
			return null;
		}
		Date d;
		try {
			d = dateFormat.parse(inputDialog.getValue());
		} catch (ParseException e1) {
			return null;
		}
		return d;
	}


}
