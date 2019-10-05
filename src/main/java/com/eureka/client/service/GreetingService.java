package com.eureka.client.service;

import com.eureka.client.consumer.GreetingConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingConsumer greetingConsumer;

    @Autowired
    public GreetingService(GreetingConsumer greetingConsumer) {
        this.greetingConsumer = greetingConsumer;
    }

    public String sayHelloToUser(String username) {
        String greeting = greetingConsumer.getRandomGreeting();
        return greeting + " " + username + "!";
    }
}