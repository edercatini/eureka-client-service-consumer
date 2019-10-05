package com.eureka.client.consumer;

import com.eureka.client.service.EurekaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class GreetingConsumer {

    @Value("${app.greetingService.serviceId}")
    private String greetingServiceId;

    @Value("${app.greetingService.endpoint.greeting}")
    private String greetingEndpointUri;

    private final RestTemplate restTemplate;

    private final EurekaService eurekaService;

    @Autowired
    private GreetingConsumer(RestTemplate restTemplate, EurekaService eurekaService) {
        this.restTemplate = restTemplate;
        this.eurekaService = eurekaService;
    }

    public String getRandomGreeting() {
        URI uri = eurekaService.getInstance(greetingServiceId);
        return restTemplate.getForObject(uri + greetingEndpointUri, String.class);
    }
}