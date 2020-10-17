package com.example.bank.controller;

import com.example.bank.dto.Document;
import com.example.bank.dto.PreRegistration;
import com.example.bank.entity.DocumentEntity;
import com.example.bank.service.DocumentService;
import com.example.bank.service.PreRegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/document")
public class DocumentController {

    private DocumentService documentService;
    private PreRegistrationService preRegistrationService;
    private ObjectMapper objectMapper;

    public DocumentController(DocumentService documentService, PreRegistrationService preRegistrationService, ObjectMapper objectMapper) {
        this.documentService = documentService;
        this.preRegistrationService = preRegistrationService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/{id}")
    public ResponseEntity createDocument(@PathVariable() UUID id,
                                         @RequestPart(value = "file") MultipartFile file
    ) throws IOException {

        var preRegistrationEntity = preRegistrationService.getPreRegistration(id);
        documentService.createDocument(objectMapper.convertValue(preRegistrationEntity, PreRegistration.class), file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<DocumentEntity>> getDocuments() {
        List<DocumentEntity> documentEntityList = documentService.getDocuments();
        return ResponseEntity.status(HttpStatus.OK).body(documentEntityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable() UUID id) {
        Document document = documentService.getDocument(id);
        return ResponseEntity.status(HttpStatus.OK).body(document);
    }
}
