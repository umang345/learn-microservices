package com.umang345.userservicezookeeperdemo.controller;

import com.umang345.userservicezookeeperdemo.entities.User;
import com.umang345.userservicezookeeperdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> response = new HashMap<>();
        if(user==null){
            User nullUser = User.builder().id(0).firstName(null).lastName(null).email(null).build();
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("data", nullUser);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        response.put("status", HttpStatus.OK.value());
        response.put("data", user);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.getAllUser();
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("data", users);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        User createdUser = userService.createUser(newUser);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.CREATED.value());
        response.put("data", createdUser);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long userId){

        User updateUser = userService.updateUser(user,userId);
        Map<String, Object> response = new HashMap<>();
        if(updateUser==null){
            User nullUser = User.builder().id(0).firstName(null).lastName(null).email(null).build();
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("data", nullUser);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        response.put("status", HttpStatus.OK.value());
        response.put("data", updateUser);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId)
    {
         userService.deleteUser(userId);
         return ResponseEntity.ok().body("User deleted successfully with Id : "+userId);
    }
}















