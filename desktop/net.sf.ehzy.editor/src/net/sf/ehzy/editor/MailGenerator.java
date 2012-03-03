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

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import net.sf.ehzy.model.Meter;
import net.sf.ehzy.model.Readout;
import net.sf.ehzy.model.Recipient;
import net.sf.ehzy.preferences.IPreferences;

import org.eclipse.emf.common.util.EList;

/**
 * This class generates and sends the messages to recipients.
 * @see SendMessageHandler
 * @author vwegert
 *
 */
public class MailGenerator {

	private static final int NUM_CSV_READOUTS = 100; // TODO move this value to preferences
	
	private SimpleDateFormat dateFormat;
	private String sender;
	private String subjectTemplate;
	private String bodyTemplate;

	private Session session;
	
	/**
	 * Default constructor.
	 */
	public MailGenerator() {
		IPreferences preferences = EHZyEditorPlugin.INSTANCE.getPreferences();
		sender = preferences.getSenderAddress();
		subjectTemplate = preferences.getSubjectTemplate();
		bodyTemplate = preferences.getBodyTemplate();
		dateFormat = new SimpleDateFormat(preferences.getDateFormat());
		
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", preferences.getSMTPServer()); //$NON-NLS-1$
		properties.setProperty("mail.smtp.port", Integer.toString(preferences.getSMTPPort())); //$NON-NLS-1$
		properties.setProperty("mail.user",      preferences.getSMTPUser()); //$NON-NLS-1$
		properties.setProperty("mail.password",  preferences.getSMTPPassword()); //$NON-NLS-1$
		session = Session.getDefaultInstance(properties);
	}
	
	/**
	 * Generates and sends the mail to a recipient.
	 * @param rec
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void sendMail(Recipient rec) throws AddressException, MessagingException, IOException {
		// get the most recent readouts
		EList<Readout> readouts = rec.getMeter().getMostRecentReadouts(NUM_CSV_READOUTS);
		Readout readout = readouts.get(readouts.size() - 1);
		
		// assemble the CSV file 
		StringBuilder sb = new StringBuilder();
		for (Readout r: readouts) {
			sb.append(MessageFormat.format("{0};{1}\n", dateFormat.format(r.getDate()), DecimalFormat.getNumberInstance().format(r.getTotalConsumption()))); //$NON-NLS-1$
		}
		
		// expand the header and subject templates
		String subject = expandTemplate(subjectTemplate, rec, readout);
		String body = expandTemplate(bodyTemplate, rec, readout);
		
		// create a multipart message container
		Multipart multipart = new MimeMultipart();
		
		// add the message body
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(body);
		multipart.addBodyPart(messageBodyPart);
		
		// add the CSV attachment
		BodyPart csvBodyPart = new MimeBodyPart();
		csvBodyPart.setFileName(MessageFormat.format("{0}.csv", rec.getMeter().getDeviceID())); //$NON-NLS-1$
		DataSource csvDataSource = new ByteArrayDataSource(sb.toString(), "text/csv"); //$NON-NLS-1$
		csvBodyPart.setDataHandler(new DataHandler(csvDataSource));
		multipart.addBodyPart(csvBodyPart);
		
		// add the SML binary attachment
		BodyPart smlBodyPart = new MimeBodyPart();
		smlBodyPart.setFileName(MessageFormat.format("{0}.sml", rec.getMeter().getDeviceID())); //$NON-NLS-1$
		DataSource smlDataSource = new ByteArrayDataSource(readout.getMessageContents(), "application/octet-stream"); //$NON-NLS-1$
		smlBodyPart.setDataHandler(new DataHandler(smlDataSource));
		multipart.addBodyPart(smlBodyPart);
		
		// assemble the message container
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sender));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(rec.getAddress()));
		message.setSubject(subject);
		message.setContent(multipart);

		// send the message
		Transport.send(message);
	}

	/**
	 * Takes a template string and replaces the placeholders with the actual values.
	 * @param template
	 * @param rec
	 * @param readout
	 * @return
	 */
	private String expandTemplate(String template, Recipient rec, Readout readout) {
		assert(rec.getMeter() == readout.getMeter());
		final Meter meter = rec.getMeter();
		String temp = template;
		temp = temp.replaceAll("\\$\\{meter_id\\}", meter.getDeviceID()); //$NON-NLS-1$
		temp = temp.replaceAll("\\$\\{meter_desc\\}", meter.getDescription()); //$NON-NLS-1$
		temp = temp.replaceAll("\\$\\{rec_salutation\\}", rec.getSalutation()); //$NON-NLS-1$
		temp = temp.replaceAll("\\$\\{readout_date\\}", dateFormat.format(readout.getDate())); //$NON-NLS-1$
		temp = temp.replaceAll("\\$\\{readout_value\\}", DecimalFormat.getNumberInstance().format(readout.getTotalConsumption())); //$NON-NLS-1$
		return temp;
	}
	
}
