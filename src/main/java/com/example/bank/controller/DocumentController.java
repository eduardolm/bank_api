package com.example.bank.controller;

import com.example.bank.dto.Document;
import com.example.bank.dto.PreRegistration;
import com.example.bank.entity.DocumentEntity;
import com.example.bank.service.DocumentService;
import com.example.bank.service.PreRegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("v1/document")
public class DocumentController {

    private DocumentService documentService;
    private PreRegistrationService preRegistrationService;
    private ObjectMapper objectMapper;

    public DocumentController(DocumentService documentService,
                              PreRegistrationService preRegistrationService,
                              ObjectMapper objectMapper) {

        this.documentService = documentService;
        this.preRegistrationService = preRegistrationService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/{id}")
    public ResponseEntity createDocument(@PathVariable() UUID id,
                                         @RequestPart(value = "file") MultipartFile file) throws Exception {

        JSONObject json = new JSONObject();
        try {
            var preRegistrationEntity = preRegistrationService.getPreRegistration(id);
            documentService.createDocument(objectMapper.convertValue(preRegistrationEntity,
                    PreRegistration.class), file);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .replacePath("/v1/review")
                    .build()
                    .toUri();
            return ResponseEntity.created(location).build();
        }
        catch (NoSuchElementException ex) {
            json.put("Error", "Not Found");
            json.put("Code", 404);
            json.put("Message", "Não existe proposta associada a este arquivo.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
        }
        catch (MultipartException | MissingServletRequestPartException ex) {
            json.put("Error","Bad Request");
            json.put("Code", 400);
            json.put("Message", "Arquivo não encontrado ou inválido.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
        }
        catch (Exception ex) {
            json.put("Error","Unprocessable Entity");
            json.put("Code", 422);
            json.put("Message", "Não foi possível processar sua solicitação. Se o erro persistir, entre em contato " +
                    "com a equipe de TI do banco.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

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
