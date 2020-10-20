package com.example.bank.controller;

import com.example.bank.dto.RequestToken;
import com.example.bank.service.RequestTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/token")
public class RequestTokenController {

    private RequestTokenService requestTokenService;

    public RequestTokenController(RequestTokenService requestTokenService) {
        this.requestTokenService = requestTokenService;
    }

    @PostMapping
    public ResponseEntity createToken(@RequestBody RequestToken requestToken) {
        var response = requestTokenService.createToken(requestToken.getEmail(), requestToken.getCpf());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
