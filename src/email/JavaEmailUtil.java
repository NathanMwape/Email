package email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author NATHAN
 */
public class JavaEmailUtil {
    
    static void sedmail(String recipient) throws Exception {
        System.out.println("preparation d'envoie d'email");
        
        String myCount = "mnathanmwape20@gmail.com";
        String password = "dgjknmnovseuornu";
        
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");//TLS
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        
    
    
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myCount, password);
            }
        });
        
        Message message = prepareMessage(session, myCount, recipient);
        Transport.send(message);
        System.out.println("Message envoyer avec succe");
    }
    
    public static Message prepareMessage(Session session, String myCount, String recipient){
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myCount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("My email from JAVA");
            message.setText("Premier mail");
            return message;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    
}
