package com.umang345.mailserviceasynccommunicationenableasync.services;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface MailService
{
    void sendMail(String message, String subject, String to, String from);
}
