package uz.pdp.contest_web.utils;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender {

    private static final String username = "obidsattarovich3600@gmail.com";
    private static final String password = "qabwtnqpmespcvbf";

    public static void sendEmail(String email, String a,String  b) throws MessagingException {

        var properties = getProperties();
        var session = getSession(properties, username, password);
        var message = new MimeMessage(session);
        var recipient = email;

        message.setSubject("This is Subject For Test Message");
        message.setContent("<h1 style=\"color:red;\">Body of mail here</h1>","text/html");
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        Transport.send(message);
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }


    private static Session getSession(Properties properties, String username, String password) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}