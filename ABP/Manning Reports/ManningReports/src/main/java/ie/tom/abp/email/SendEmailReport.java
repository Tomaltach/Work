package ie.tom.abp.email;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailReport {
	private String path;
	private String fileName;
	private String ip;
	private String emails;

	public SendEmailReport(String path, String fileName, String ip, String emails) {
		this.path = path;
		this.fileName = fileName;
		this.ip = ip;
		this.emails = emails;
		sendEmail();
	}
	private void sendEmail() {
		try {
			String smtpServer = ip;
			System.out.println(emails);
			String to = emails;
			//String to = "Thomas.Donegan@abpireland.com";
			//String from = "BanBHSupervisor.Reports@abpireland.com";
			String from = "Thomas.Donegan@abpireland.com";
			String subject = "Manning Report";
			String body = "Manning Report";
			String attachment = path + fileName;
			send(smtpServer, to, from, subject, body, attachment);
		} catch(Exception ex) {
			System.out.println("Usage: java com.lotontech.mail.SimpleSender" +
					" smtpServer toAddress fromAddress subjectText bodyText");
	    }
	}
	private void send(String smtpServer, String to, String from, String subject, String body, String attachment) {
		try {
			System.setProperty("java.net.preferIPv4Stack" , "true");
			Properties props = System.getProperties();
			// -- Attaching to default Session, or we could start a new one --
			props.put("mail.smtp.host", smtpServer);
			Session session = Session.getDefaultInstance(props, null);
			
			// -- Create a new message --
			Message msg = new MimeMessage(session);
			
			// -- Set the FROM and TO fields --
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject(subject);
			
			// -- Set the BODY field --
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachment);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);
			
			msg.setContent(multipart);
			
			// -- Set some other header information --
			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());
			
			// -- Send the message --
			Transport.send(msg);
			System.out.println("Message sent OK.");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}