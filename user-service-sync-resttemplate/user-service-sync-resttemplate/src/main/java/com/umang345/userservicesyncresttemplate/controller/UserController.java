package com.umang345.userservicesyncresttemplate.controller;

import com.umang345.userservicesyncresttemplate.entities.User;
import com.umang345.userservicesyncresttemplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId)
    {
        User user = userService.getUserById(userId);
        if(user==null){
            User nullUser = User.builder().id(0).firstName(null).lastName(null).email(null).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nullUser);
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        User createdUser = userService.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long userId){

        User updateUser = userService.updateUser(user,userId);
        if(updateUser==null){
            User nullUser = User.builder().id(0).firstName(null).lastName(null).email(null).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nullUser);
        }
        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId)
    {
         userService.deleteUser(userId);
         return ResponseEntity.ok().body("User deleted successfully with Id : "+userId);
    }
}















