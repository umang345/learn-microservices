package com.umang345.userservicezookeeperdemo.services;


import com.umang345.userservicezookeeperdemo.entities.User;
import com.umang345.userservicezookeeperdemo.exceptions.ResourceNotFoundException;
import com.umang345.userservicezookeeperdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User newUser) {
        User savedUser = userRepository.save(newUser);
        return savedUser;
    }

    @Override
    public User getUserById(long userId)  {
        User fetchedUser = null;
        try {
            fetchedUser = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id : "+userId));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return fetchedUser;
    }

    @Override
    public User updateUser(User user, long userId) {
        User currentUser = null;
        try {
            currentUser = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id : "+userId));
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            currentUser.setEmail(user.getEmail());

        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        User updateUser = userRepository.save(currentUser);
        return updateUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public void deleteUser(long userId) {
        User currentUser = null;
        try {
            currentUser = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id : "+userId));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }

        userRepository.delete(currentUser);
    }
}
