package com.example.bank.controller;

import com.example.bank.controller.request.PreRegistrationEditRequest;
import com.example.bank.dto.PreRegistration;
import com.example.bank.entity.PreRegistrationEntity;
import com.example.bank.service.PreRegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/registrations")
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
    public ResponseEntity createPreRegistration(@Valid @RequestBody PreRegistration preRegistration) {

        try {
            preRegistrationService.createPreRegistration(preRegistration);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .replacePath("/v1/proposals")
                    .build()
                    .toUri();
            return ResponseEntity.created(location).build();
        }
        catch (Exception ex) {
            JSONObject jsonObject = new JSONObject();
            if (ex.getMessage().equals("É preciso ter mais de 18 anos para abrir uma conta.")) {
                jsonObject.put("Message", ex.getMessage());
            } else{
                jsonObject.put("Erro", "Dados já existem em nossos cadastros.");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject);
        }
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
