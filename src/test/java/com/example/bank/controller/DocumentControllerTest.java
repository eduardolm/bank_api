package com.example.bank.controller;

import com.example.bank.entity.DocumentEntity;
import com.example.bank.entity.PreRegistrationEntity;
import com.example.bank.service.DocumentService;
import com.example.bank.service.PreRegistrationService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DocumentControllerTest {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PreRegistrationService preRegistrationService;

    @Test
    public void testConstructor() {
        // Arrange and Act
        new DocumentController(this.documentService, this.preRegistrationService, this.objectMapper);

        // Assert
        List<DocumentEntity> documents = this.documentService.getDocuments();
        assertEquals(0, documents.size());
        List<PreRegistrationEntity> preRegistrations = this.preRegistrationService.getPreRegistrations();
        assertEquals(0, preRegistrations.size());
        JsonFactory factory = this.objectMapper.getFactory();
        assertTrue(factory instanceof MappingJsonFactory);
        assertTrue(this.objectMapper
                .getDeserializationContext() instanceof com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl);
        assertNull(this.objectMapper.getPropertyNamingStrategy());
        assertTrue(this.objectMapper.getDateFormat() instanceof com.fasterxml.jackson.databind.util.StdDateFormat);
        assertSame(factory, this.objectMapper.getJsonFactory());
        assertTrue(
                this.objectMapper.getSerializerFactory() instanceof com.fasterxml.jackson.databind.ser.BeanSerializerFactory);
    }
}

