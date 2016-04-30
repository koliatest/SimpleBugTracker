package com.sprsec.Helper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    private String username = "testfortracker";
    private String password = "marvelqwerty";
    private Properties props;

    public EmailSender()
    {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }

    public EmailSender(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void send(String subject, String text, String toEmail){
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            //from who
            message.setFrom(new InternetAddress(username));
            //to
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //Subject
            message.setSubject(subject);
            //Body
            message.setText(text);

            //Send msg
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

