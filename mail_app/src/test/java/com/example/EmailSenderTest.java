package com.example;

import com.example.helper.Message;
import com.example.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    void  emailSendTest(){
        System.out.println("sending email");
        emailService.sendEmail("madhav75solanki@gmail.com","Test mail Spring boot","Hi I am from spring boot app");
    }

    @Test
    void  sentHtmlInMail(){

        String html = "<h1 style='color:red; border: 1px solid black;'>Hi Welcome, This is an HTML Body content</h1>";
        emailService.sendEmailWithHtml("madhav75solanki@gmail.com","Test ail from spring boot", html);
    }


    @Test
    void sendEmailWithFile(){
        emailService.sendEmailWithFile("madhav75solanki@gmail.com",
                "Email with file",
                "Email contains file" ,
                new File("D:\\Development\\JAVA Backend\\Spring Boot\\mail_app\\src\\main\\resources\\static\\profile.webp"));
    }

    @Test
    void sendEmailWithStream(){
        File file =   new File("D:\\Development\\JAVA Backend\\Spring Boot\\mail_app\\src\\main\\resources\\static\\profile.webp");

        try {
            InputStream is = new FileInputStream(file);
            emailService.sendEmailWithFile("madhav75solanki@gmail.com",
                    "Email with new file",
                    "This file contains new file", is);
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }


    // Receiving Email Test
    @Test
    void getInbox() {
        List<Message> inboxMessages = emailService.getInboxMessages();

        inboxMessages.forEach(item -> {
            System.out.println("Subject: " + item.getSubjects());
            System.out.println("Content: " + item.getContent());
            System.out.println("Files: " + item.getFiles());
            System.out.println("=================================================");
        });
    }
}
