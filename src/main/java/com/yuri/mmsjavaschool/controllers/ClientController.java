package com.yuri.mmsjavaschool.controllers;

import com.yuri.mmsjavaschool.models.Client;
import com.yuri.mmsjavaschool.services.impls.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/clients")
public class ClientController {

    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping("get")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping("add")
    public ResponseEntity<?> addUser(@RequestBody Client client) {
        clientService.addClient(client);
        return ResponseEntity.ok(client);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }
}
