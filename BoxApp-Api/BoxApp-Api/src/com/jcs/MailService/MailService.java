package com.jcs.MailService;



import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.jcs.model.Registration;

import java.util.Calendar;
import java.util.Date;

public class MailService {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
     
     
    public void mail(Registration reg) throws AddressException, MessagingException {
    	
    	generateAndSendEmail(reg);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	
 	
    }
	
    public static void generateAndSendEmail(Registration reg) throws AddressException, MessagingException {
    	 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("carlo.saggese@jcsconsulting.com"));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("Johnny.SantoSpirito@jcsconsulting.com"));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("nagendra.balachandra@jcsconsulting.com"));
		generateMailMessage.setSubject("BOX APP Used");
		
		Calendar cal = Calendar.getInstance();


		
		String emailBody = "<h4> Welcome to BOX - APP <h4> " +
		        
				"The following Account has been logged in to the BOX - APP "+
				
				"<br><br> <b>First Name</b> : " + reg.getFirstname() +
				"<br><br> <b>Last Name</b> : "+ reg.getLastname()+
				"<br><br> <b> Phone</b> : "+ reg.getPhone() +
				"<br><br> <b> Email</b> : " + reg.getEmail()+
				"<br><br> <b> Job Title</b> : " + reg.getJobtitle() +
				"<br><br> <b> Login Time</b> : " + cal.getTime() ;
		
		 
				 
				                     
				 
				   
		
		
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "bushan1891@gmail.com", "bushanrock1");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}	
	
	
	
}
