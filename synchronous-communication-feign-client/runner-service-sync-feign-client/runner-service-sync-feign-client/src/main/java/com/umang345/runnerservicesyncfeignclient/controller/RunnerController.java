package com.umang345.runnerservicesyncfeignclient.controller;

import com.umang345.runnerservicesyncfeignclient.entities.User;
import com.umang345.runnerservicesyncfeignclient.feignClients.RunnerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/simulate/users")
public class RunnerController
{
    @Autowired
    private RunnerFeignClient runnerFeignClient;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){

        Map<String,Object> response = runnerFeignClient.getAllUsers();
        return ResponseEntity.ok().body(response.get("data"));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {

        Map<String,Object> response = new HashMap<>();
        try {
            response = runnerFeignClient.getUserById(userId);
            if((Integer)response.get("status") != HttpStatus.OK.value())
            {
                 throw new Exception("User not found with Id : "+userId);
            }
            return ResponseEntity.status(HttpStatus.OK).body(response.get("data"));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User newUser){
        Map<String, Object> response = new HashMap<>();
        try {
            response = runnerFeignClient.createUser(newUser);
            if((Integer)response.get("status") != HttpStatus.CREATED.value())
            {
                throw new Exception("Error while creating user");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response.get("data"));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long userId){
        Map<String, Object> response = new HashMap<>();
        try{
            response = runnerFeignClient.updateUser(user,userId);
            if((Integer)response.get("status") != HttpStatus.OK.value())
            {
                throw new Exception("User not found with Id : "+userId);
            }

            return ResponseEntity.status(HttpStatus.OK).body(response.get("data"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId)
    {
         try {
                runnerFeignClient.deleteUser(userId);
             return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully with id : "+userId);
         }catch (Exception e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with Id : "+userId);
         }
    }
}
