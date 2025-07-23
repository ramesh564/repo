package packg;



import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Properties;

import org.apache.poi.util.StringUtil;
import org.testng.annotations.AfterSuite;


public class EmailReportsender {

	public static void sendReport(String toEmail, String fromEmail, String password) {
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Automation Test Report - TestNG");

            // Body text
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hi,\n\nPlease find the attached automation test report.\n\nRegards,\nAutomation Team");

            // Attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File("test-output/emailable-report.html"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            // Send it
            Transport.send(message);
            System.out.println("✅ Report sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
      
    }
}
	
	
	

