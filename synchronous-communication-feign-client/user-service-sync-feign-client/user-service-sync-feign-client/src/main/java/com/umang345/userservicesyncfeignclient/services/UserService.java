package com.umang345.userservicesyncfeignclient.services;

import com.umang345.userservicesyncfeignclient.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService
{
    User createUser(User newUser);

    User getUserById(long userId);

    User updateUser(User user, long userId);

    List<User> getAllUser();

    void deleteUser(long userId);
}
