package com.umang345.userserviceasynccommunicationenableasync.services;

import com.umang345.userserviceasynccommunicationenableasync.entities.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService
{
    User createUser(User newUser);
}
