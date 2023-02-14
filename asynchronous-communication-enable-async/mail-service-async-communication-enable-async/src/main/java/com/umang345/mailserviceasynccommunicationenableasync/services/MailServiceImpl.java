package com.umang345.mailserviceasynccommunicationenableasync.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService
{

    @Value("${authentication.username}")
    private String AUTHENTICATION_USERNAME;

    @Value("${authentication.password}")
    private String AUTHENTICATION_PASSWORD;

    @Override
    public void sendMail(String message, String subject, String to, String from) {
        //Variable for gmail
        String host="smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step 1: to get the session object..
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(AUTHENTICATION_USERNAME,
                        AUTHENTICATION_PASSWORD);
            }
        });

        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);


        try {

            //from email
            m.setFrom(from);

            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);


            //adding text to message
            m.setText(message);

            //send

            //Step 3 : send the message using Transport class
            Transport.send(m);

            System.out.println("Sent success...................");



        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
