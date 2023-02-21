package uz.pdp.contest_web.utils;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender {

    public static boolean sendEmail(String email, String subject,String  body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("obidsattarovich3600@gmail.com", "qabwtnqpmespcvbf");
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("obidsattarovich3600@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tulaevmuhammad12@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}


