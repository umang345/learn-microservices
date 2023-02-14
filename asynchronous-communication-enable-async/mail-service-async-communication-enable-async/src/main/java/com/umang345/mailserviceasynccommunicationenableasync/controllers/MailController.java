package com.umang345.mailserviceasynccommunicationenableasync.controllers;

import com.umang345.mailserviceasynccommunicationenableasync.entities.User;
import com.umang345.mailserviceasynccommunicationenableasync.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mail")
public class MailController
{
    @Autowired
    private MailService mailService;

    @Value("${authentication.username}")
    private String FROM;

    @PostMapping
    public Map<String,Object> sendMail(@RequestBody User user) {
        StringBuilder message = new StringBuilder();
        message.append("Hi ");
        message.append(user.getFirstName());
        message.append(", Your new account is created Successfully");
        String subject = "New Account Created";

        mailService.sendMail(
                message.toString(),
                subject,
                user.getEmail(),
                FROM
        );

        Map<String,Object> response = new HashMap<>();
        response.put("status",true);

        return response;

    }
}
