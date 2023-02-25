package com.umang345.runnerserviceasyncrabbitmq.controller;

import com.umang345.runnerserviceasyncrabbitmq.configs.UserMessageQueueConfig;
import com.umang345.runnerserviceasyncrabbitmq.entities.RunnerResponseDto;
import com.umang345.runnerserviceasyncrabbitmq.entities.User;
import com.umang345.runnerserviceasyncrabbitmq.entities.UserMailQueueMessage;
import com.umang345.runnerserviceasyncrabbitmq.entities.UserResponseDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/simulate/users")
public class RunnerController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

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


            UserMailQueueMessage userMailQueueMessage =
                    UserMailQueueMessage.builder()
                    .mailQueueMessageId(UUID.randomUUID().toString())
                    .queueMessageDate(new Date())
                    .userMessage(newUser)
                    .build();

            rabbitTemplate.convertAndSend(
                    UserMessageQueueConfig.EXCHANGE_NAME,
                    UserMessageQueueConfig.ROUTING_KEY,
                    userMailQueueMessage
            );

            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
