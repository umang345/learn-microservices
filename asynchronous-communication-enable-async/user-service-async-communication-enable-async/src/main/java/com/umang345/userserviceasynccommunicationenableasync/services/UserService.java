package com.umang345.userserviceasynccommunicationenableasync.services;

import com.umang345.userserviceasynccommunicationenableasync.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService
{
    User createUser(User newUser);

//    User getUserById(long userId);
//
//    User updateUser(User user, long userId);
//
//    List<User> getAllUser();
//
//    void deleteUser(long userId);
}
