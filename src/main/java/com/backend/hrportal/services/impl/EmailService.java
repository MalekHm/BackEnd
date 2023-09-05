package com.backend.hrportal.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;


    // Method 1
    // To send a simple email
    public String sendResponseHoliday(String to, Date start, Date end) {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("femarwa965@gmail.com");
            mailMessage.setTo(to);
            mailMessage.setSubject("VermegHR - Votre demande a été approuvée");
            mailMessage.setText("La demande d'absence suivante a été approuvée:\n");
            mailMessage.setText("De : " + start);
            mailMessage.setText("Au : " + end);

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
    public String sendResponseRemote(String to, Date start, Date end) {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("femarwa965@gmail.com");
            mailMessage.setTo(to);
            mailMessage.setSubject("VermegHR - Votre demande a été approuvée");
            mailMessage.setText("La demande d'absence suivante a été approuvée:\n");
            mailMessage.setText("De : " + start);
            mailMessage.setText("Au : " + end);

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
    public String sendResponsePermission(String to, String start, String end) {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("femarwa965@gmail.com");
            mailMessage.setTo(to);
            mailMessage.setSubject("VermegHR - Votre demande a été approuvée");
            mailMessage.setText("La demande d'absence suivante a été approuvée:\n");
            mailMessage.setText("De : " + start);
            mailMessage.setText("Au : " + end);

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
}