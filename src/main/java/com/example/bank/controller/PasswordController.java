package com.example.bank.controller;

import com.example.bank.dto.Token;
import com.example.bank.service.PasswordService;
import com.example.bank.service.PreRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/passwords")
public class PasswordController {

    private PasswordService passwordService;
    private PreRegistrationService preRegistrationService;

    public PasswordController(PasswordService passwordService, PreRegistrationService preRegistrationService) {

        this.passwordService = passwordService;
        this.preRegistrationService = preRegistrationService;
    }

    @PostMapping
    public ResponseEntity createPassword(@RequestBody Token token) {

        var response = passwordService.createPassword(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPassword(@PathVariable() UUID id) {

        var response = passwordService.getPassword(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
