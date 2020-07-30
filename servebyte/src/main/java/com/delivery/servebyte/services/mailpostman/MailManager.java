package com.delivery.servebyte.services.mailpostman;

public interface MailManager {
    void sendEmail(String email, String subject, String text);
}
