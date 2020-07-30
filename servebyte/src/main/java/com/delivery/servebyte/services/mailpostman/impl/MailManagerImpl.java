package com.delivery.servebyte.services.mailpostman.impl;

import com.delivery.servebyte.services.mailpostman.MailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailManagerImpl implements MailManager {

    @Autowired
    private JavaMailSender mailSender;

    Environment env;

    public void sendEmail(String email, String subject, String text) {
        String officialMail = "mkpadieche@gmail.com";
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email, officialMail);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
