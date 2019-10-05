package com.eureka.client.controller;

import com.eureka.client.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class UserGreetingController {

    private final GreetingService greetingService;

    @Autowired
    public UserGreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/{username}")
    public String getGreeting(@PathVariable String username) {
        return greetingService.sayHelloToUser(username);
    }
}