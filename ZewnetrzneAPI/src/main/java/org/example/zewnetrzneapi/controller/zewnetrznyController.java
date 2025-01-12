package org.example.zewnetrzneapi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class zewnetrznyController {
    @GetMapping("/info/{type}")
    public String info(@PathVariable String type) {
        return "The information is about " + type;
    }
}
