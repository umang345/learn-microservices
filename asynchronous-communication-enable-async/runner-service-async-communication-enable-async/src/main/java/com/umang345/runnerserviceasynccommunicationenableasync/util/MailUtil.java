package com.umang345.runnerserviceasynccommunicationenableasync.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MailUtil {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public void sendMail(String url, HttpMethod httpMethod, HttpEntity<?> httpEntity, Class<?> c)
    {
        restTemplate.exchange(url
                ,httpMethod
                ,httpEntity
                ,c);
    }
}
