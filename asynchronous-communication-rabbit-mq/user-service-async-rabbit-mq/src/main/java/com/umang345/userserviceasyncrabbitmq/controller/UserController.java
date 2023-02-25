package com.umang345.userserviceasyncrabbitmq.controller;

import com.umang345.userserviceasyncrabbitmq.entities.User;
import com.umang345.userserviceasyncrabbitmq.entities.UserResponseDto;
import com.umang345.userserviceasyncrabbitmq.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        User createdUser = userService.createUser(newUser);
        UserResponseDto response = UserResponseDto.builder()
                                    .status(HttpStatus.CREATED.value())
                                    .data(createdUser)
                                    .build();
        return ResponseEntity.ok().body(response);
    }
}















