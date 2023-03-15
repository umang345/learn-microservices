package com.umang345.consul.runnerservice.controller;

import com.umang345.consul.runnerservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/simulate/users")
public class RunnerController
{
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        ResponseEntity<Map> response = restTemplate.exchange("http://USER-SERVICE/users",HttpMethod.GET,new HttpEntity<>(new HttpHeaders()),Map.class);
        return ResponseEntity.ok().body(response.getBody().get("data"));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {

        ResponseEntity<Map> response = null;
        try {
            response = restTemplate.exchange("http://USER-SERVICE/users/"+userId,HttpMethod.GET,new HttpEntity<Map>(new HttpHeaders()), Map.class);
            Map<String,Object> res = response.getBody();
            if((Integer)res.get("status") != HttpStatus.OK.value())
            {
                 throw new Exception("User not found with Id : "+userId);
            }

            return ResponseEntity.status(HttpStatus.OK).body(res.get("data"));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User newUser){
        ResponseEntity<Map> response = null;
        try {
            response = restTemplate.exchange("http://USER-SERVICE/users",HttpMethod.POST,new HttpEntity<>(newUser),Map.class);

            Map<String,Object> res = response.getBody();
            if((Integer)res.get("status") != HttpStatus.CREATED.value())
            {
                throw new Exception("Error while creating user");
            }

            return ResponseEntity.status(HttpStatus.OK).body(res.get("data"));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long userId){
        ResponseEntity<Map> response = null;
        try{
            response = restTemplate.exchange("http://USER-SERVICE/users/"+userId,HttpMethod.PUT,new HttpEntity<>(user),Map.class);

            Map<String,Object> res = response.getBody();
            if((Integer)res.get("status") != HttpStatus.OK.value())
            {
                throw new Exception("User not found with Id : "+userId);
            }

            return ResponseEntity.status(HttpStatus.OK).body(res.get("data"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId)
    {
         try {
             ResponseEntity<String> response = restTemplate.exchange("http://USER-SERVICE/users/"+userId, HttpMethod.DELETE, new HttpEntity<User>(new HttpHeaders()), String.class);

             return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully with id : "+userId);
         }catch (Exception e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with Id : "+userId);
         }


    }



}
