package sendmail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

public class SendMail {

  /**
   *  The main program for the SendMail class
   */
  public static void main(String[] args) throws Exception {
    System.out.println("hello");

    //String host = "mailhost.math.luc.edu";
    String host = "YOUR ISP'S SMTP HOST";
    String from = "SOME EMAIL ADDRESS";
    String to = "YOUR EMAIL ADDRESS";

    // Get system properties
    Properties props = System.getProperties();

    // Setup mail server
    props.put("mail.smtp.host", host);

    // Get session
    Session session = Session.getDefaultInstance(props, null);

    System.out.println("hello 1");

    try {
      // Define message
      MimeMessage message = new MimeMessage(session);

      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO,
     	  new InternetAddress(to));
      message.setSubject("Hello JavaMail");
      message.setText("Welcome to JavaMail");

      // Send message
      Transport.send(message);
      System.out.println("hello 2");
    } catch (MessagingException e) {
      e.printStackTrace(System.err);
    }

    System.out.println("goodbye");
  }
}
