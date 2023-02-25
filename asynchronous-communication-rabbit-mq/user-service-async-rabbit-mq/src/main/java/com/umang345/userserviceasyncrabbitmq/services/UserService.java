package com.umang345.userserviceasyncrabbitmq.services;

import com.umang345.userserviceasyncrabbitmq.entities.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService
{
    User createUser(User newUser);
}
