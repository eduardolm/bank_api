package com.example.bank.controller;

import com.example.bank.controller.request.PreRegistrationEditRequest;
import com.example.bank.dto.PreRegistration;
import com.example.bank.entity.PreRegistrationEntity;
import com.example.bank.service.PreRegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/registration")
public class PreRegistrationController {

    private PreRegistrationService preRegistrationService;
    private ObjectMapper objectMapper;

    public PreRegistrationController(PreRegistrationService preRegistrationService, ObjectMapper objectMapper) {

        this.preRegistrationService = preRegistrationService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<PreRegistrationEntity>> getPreRegistrations() {

        List<PreRegistrationEntity> preRegistrationListResponses = preRegistrationService.getPreRegistrations();
        return ResponseEntity.status(HttpStatus.OK).body(preRegistrationListResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreRegistrationEntity> getPreRegistration(@PathVariable() UUID id) {

        PreRegistrationEntity preRegistration = preRegistrationService.getPreRegistration(id);
        return ResponseEntity.status(HttpStatus.OK).body(preRegistration);
    }

    @PostMapping
    public ResponseEntity createPreRegistration(@Valid @RequestBody PreRegistration preRegistration) throws FileNotFoundException {

        preRegistrationService.createPreRegistration(preRegistration);;
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreRegistrationEntity> updatePreRegistration(
            @PathVariable() UUID id,
            @Valid @RequestBody PreRegistrationEditRequest preRegistrationEditRequest) {

        var status = preRegistrationEditRequest.getStatus();
        preRegistrationService.updatePreRegistration(id, preRegistrationEditRequest, status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
