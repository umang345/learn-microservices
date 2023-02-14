package com.umang345.userserviceasynccommunicationenableasync.services;

import com.umang345.userserviceasynccommunicationenableasync.entities.User;
import com.umang345.userserviceasynccommunicationenableasync.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User newUser) {
        User savedUser = userRepository.save(newUser);
        return savedUser;
    }
}
