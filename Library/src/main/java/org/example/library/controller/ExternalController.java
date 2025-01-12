package org.example.library.controller;

import org.example.library.client.ExternalServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalController {
    private final ExternalServiceClient externalServiceClient;

    public ExternalController(ExternalServiceClient externalServiceClient) {
        this.externalServiceClient = externalServiceClient;
    }

    @GetMapping("/info/{type}")
    public String fetchInfo(@PathVariable String type) {
        return externalServiceClient.getGeneralInfo(type);
    }
}
