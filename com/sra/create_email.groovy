/* Create a new e-mail message */
MimeMessage message = new MimeMessage(session);
 
 /* Create body part for the message */
BodyPart messageBodyPart = new MimeBodyPart();
messageBodyPart.setText(body);
 
/* Create the multipart */
Multipart multipart = new MimeMultipart();
multipart.addBodyPart(messageBodyPart);
messageBodyPart = new MimeBodyPart();
 
/* Add attachment */
DataSource source = new FileDataSource(filename);
messageBodyPart.setDataHandler(new DataHandler(source));
messageBodyPart.setFileName(filename);
multipart.addBodyPart(messageBodyPart);
message.setContent(multipart);




import javax.mail.*
import javax.mail.internet.*
import javax.activation.*
 
public static void simpleMail(String from, String password, String to,
                              String subject, String body, String filename) throws Exception {
      
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable",true);
        /* mail.smtp.ssl.trust is needed in script to avoid error "Could not convert socket to TLS"  */ 
        props.setProperty("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.auth", true);      
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
      
        Session session = Session.getDefaultInstance(props, null);
     
        /* Create a new e-mail message */
     
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
     
        InternetAddress toAddress = new InternetAddress(to);
     
        message.addRecipient(Message.RecipientType.TO, toAddress);
        message.setSubject(subject);
     
        /* Create body part for the message */
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(body);
     
        /* Create the multipart */
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        messageBodyPart = new MimeBodyPart();
     
        /* Add attachment */
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);
     
        Transport transport = session.getTransport("smtp");
        transport.connect(host, from, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
}
 
/* Set email address sender */
String s1 = "example@gmail.com";
 
/* Set password sender */
String s2 = "";
 
/* Set email address receiver */
String s3 = "example@gmail.com";
 
/* Set file */
String filename = "C:/Temp/Export to Excel/Excel_Report.xlsx";
   
/* Call function */
simpleMail(s1, s2 , s3, "TITLE", "TEXT", filename);