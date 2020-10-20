package com.example.bank.controller;

import com.example.bank.entity.AccountEntity;
import com.example.bank.service.AccountService;
import com.example.bank.service.PreRegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/accounts")
public class AccountController {

    private AccountService accountService;
    private ObjectMapper objectMapper;
    private PreRegistrationService preRegistrationService;

    public AccountController(AccountService accountService,
                             ObjectMapper objectMapper,
                             PreRegistrationService preRegistrationService) {

        this.accountService = accountService;
        this.objectMapper = objectMapper;
        this.preRegistrationService = preRegistrationService;
    }

    @PostMapping("/{id}")
    public ResponseEntity createAccount(@PathVariable UUID id) {

        var response = accountService.createAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AccountEntity>> getAccounts() {

        List<AccountEntity> accountListResponses = accountService.getAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(accountListResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountEntity> getAccount(@PathVariable() UUID id) {

        AccountEntity accountEntity = accountService.getAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body(accountEntity);
    }
}
