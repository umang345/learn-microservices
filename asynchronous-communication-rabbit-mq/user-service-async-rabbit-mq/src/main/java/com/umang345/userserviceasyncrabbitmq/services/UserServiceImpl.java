package com.umang345.userserviceasyncrabbitmq.services;

import com.umang345.userserviceasyncrabbitmq.entities.User;
import com.umang345.userserviceasyncrabbitmq.repositories.UserRepository;
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
