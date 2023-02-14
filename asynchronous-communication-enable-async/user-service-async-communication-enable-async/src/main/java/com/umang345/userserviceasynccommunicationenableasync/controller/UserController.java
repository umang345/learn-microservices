package com.umang345.userserviceasynccommunicationenableasync.controller;

import com.umang345.userserviceasynccommunicationenableasync.entities.User;
import com.umang345.userserviceasynccommunicationenableasync.entities.UserResponseDto;
import com.umang345.userserviceasynccommunicationenableasync.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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















