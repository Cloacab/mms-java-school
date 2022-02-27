package com.yuri.mmsjavaschool.controllers;

import com.yuri.mmsjavaschool.models.Client;
import com.yuri.mmsjavaschool.repositories.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
public class UserController {

    private final ClientRepository clientRepository;

    public UserController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody Client client) {
        client.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.ok(savedClient);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(clientRepository.getById(id));
    }
}
