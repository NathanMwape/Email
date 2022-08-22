/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author NATHAN
 */
public class JavaMail {

    public static void main(String[] args) throws Exception {

        Properties properties;
        Session session;
        MimeMessage message;

        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");//TLS
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mnathanmwape20@gmail.com", "dgjknmnovseuornu");
            }
        };

        session = Session.getDefaultInstance(properties, auth);

        InternetAddress[] recipient = new InternetAddress[1];
        recipient[0] = new InternetAddress("mnathanmwape20@gmail.com");

        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mnathanmwape20@gmail.com"));
            message.addRecipients(Message.RecipientType.TO, recipient);
            message.setSubject("My email from JAVA");
            message.setText("message recu");

            Transport.send(message);
            System.out.println("Email envoyer");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        JavaEmailUtil.sedmail("mnathanmwape20@gmail.com");

    }

}
