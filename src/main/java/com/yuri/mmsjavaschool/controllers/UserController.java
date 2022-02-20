package com.yuri.mmsjavaschool.controllers;

import com.yuri.mmsjavaschool.models.User;
import com.yuri.mmsjavaschool.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        user.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
