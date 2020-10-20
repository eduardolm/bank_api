package com.example.bank.controller;

import com.example.bank.dto.RequestToken;
import com.example.bank.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("v1/token")
public class TokenController {

    private TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity createToken(@RequestBody RequestToken requestToken) {

        var response = tokenService.createToken(requestToken.getEmail(), requestToken.getCpf());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/v1/password")
                .build()
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getToken(@PathVariable UUID id) {

        var response = tokenService.getToken(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
