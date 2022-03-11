package com.yuri.mmsjavaschool.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DefaultController {
    @GetMapping("/resource")
    public Map<String, String> getGreeting() {
        HashMap<String, String> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "hello xyz");
        return model;
    }
}
