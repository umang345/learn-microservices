package com.umang345.runnerservicesyncfeignclient.feignClients;

import com.umang345.runnerservicesyncfeignclient.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name="RUNNER-SERVICE", url = "http://localhost:8081/users")
public interface RunnerFeignClient
{
    @GetMapping
    Map<String, Object> getAllUsers();

    @GetMapping("/{userId}")
    Map<String,Object> getUserById(@PathVariable long userId);

    @PostMapping
    Map<String,Object> createUser(User newUser);

    @PutMapping("/{userId}")
    Map<String,Object> updateUser(User user, @PathVariable Long userId);

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable Long userId);
}
