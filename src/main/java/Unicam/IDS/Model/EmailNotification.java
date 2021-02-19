package Unicam.IDS.Model;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailNotification {

    public void send(String recipient, String sender,String title, String body) {
        Properties properties = System.getProperties();
        String host = "localhost:8080";
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(title);
            message.setText("HAI UNA NUOVA NOTIFICA DALLA PIATTAFORMA CENTROCOMMERCIALEINCENTRO:" + "/n" + body +"/n questo messaggio è stato inviato a:" + recipient);

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
