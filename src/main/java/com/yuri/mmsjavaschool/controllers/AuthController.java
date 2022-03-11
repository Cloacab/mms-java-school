package com.yuri.mmsjavaschool.controllers;

import com.yuri.mmsjavaschool.models.Client;
import com.yuri.mmsjavaschool.models.dto.ClientDto;
import com.yuri.mmsjavaschool.models.dto.ClientLoginDto;
import com.yuri.mmsjavaschool.services.ClientService;
import com.yuri.mmsjavaschool.services.impls.UserAlreadyExistException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController()
@RequestMapping("/api/auth")
public class AuthController {

    private final ClientService clientService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(ClientService clientService) {
        this.clientService = clientService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid ClientLoginDto clientDto) {
        Client client = clientService.getClientByUsername(clientDto.getUsername());

        log.info(clientDto.toString());

        if (passwordEncoder.matches(clientDto.getPassword(), client.getPassword())) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid credentials.");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUserAccount(@RequestBody @Valid ClientDto clientDto) {

        log.info(clientDto.toString());

        try {
            return ResponseEntity.ok(clientService.registerNewClient(clientDto));
        } catch (UserAlreadyExistException e) {
//            mav.addObject("message", "An account for that username/email already exists.");
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
