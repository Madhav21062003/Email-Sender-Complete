package com.example.service;

import com.example.helper.Message;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface EmailService {
    

    // Send mail to single person

    void sendEmail(String to, String subject, String message);


    // Send email to multiple persons
    void sendEmail(String []to, String subject, String message);


    // send email with html
    void sendEmailWithHtml(String to, String subject, String htmlContent);

    // end email with file
    void sendEmailWithFile(String to, String subject, String message, File file);

    // send attach with device
    void sendEmailWithFile(String to, String subject, String message, InputStream is);

    // Get Messages inbox
    List<Message> getInboxMessages();
}
