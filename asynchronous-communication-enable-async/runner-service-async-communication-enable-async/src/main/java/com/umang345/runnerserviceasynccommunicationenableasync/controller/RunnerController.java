package com.umang345.runnerserviceasynccommunicationenableasync.controller;

import com.umang345.runnerserviceasynccommunicationenableasync.entities.User;
import com.umang345.runnerserviceasynccommunicationenableasync.entities.RunnerResponseDto;
import com.umang345.runnerserviceasynccommunicationenableasync.entities.UserResponseDto;
import com.umang345.runnerserviceasynccommunicationenableasync.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/simulate/users")
public class RunnerController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MailUtil mailUtil;

    @Value("${url.user-service}")
    private String userServiceUrl;

    @Value("${url.mail-service}")
    private String mailServiceUrl;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User newUser){
        ResponseEntity<UserResponseDto> response = null;
        try {

            long tm1 = System.currentTimeMillis();
            response = restTemplate.exchange(userServiceUrl,HttpMethod.POST,new HttpEntity<>(newUser), UserResponseDto.class);
            long tm2 = System.currentTimeMillis();
            System.out.println("User created in : "+((tm2-tm1)/1000.0));
            if(response.getBody().getStatus() != HttpStatus.CREATED.value())
            {
                throw new Exception("Error while creating user");
            }

            User createdUser = response.getBody().getData();

            RunnerResponseDto responseDto = RunnerResponseDto
                    .builder()
                    .user(createdUser)
                    .message("User created successfully. Mail will be sent shortly")
                    .build();



            mailUtil.sendMail(mailServiceUrl
                             ,HttpMethod.POST
                             ,new HttpEntity<>(createdUser)
                             ,Void.class);

            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
