package com.example.bank.controller;

import com.example.bank.entity.AccountEntity;
import com.example.bank.service.AccountService;
import com.example.bank.service.PreRegistrationService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AccountControllerTest {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PreRegistrationService preRegistrationService;

    @Test
    public void testConstructor() {
        // Arrange and Act
        new AccountController(this.accountService, this.objectMapper, this.preRegistrationService);

        // Assert
        List<AccountEntity> accounts = this.accountService.getAccounts();
        assertEquals(0, accounts.size());
        assertNull(this.objectMapper.getInjectableValues());
        assertTrue(
                this.objectMapper.getSerializerFactory() instanceof com.fasterxml.jackson.databind.ser.BeanSerializerFactory);
        assertTrue(this.objectMapper.getDateFormat() instanceof com.fasterxml.jackson.databind.util.StdDateFormat);
        assertTrue(this.objectMapper
                .getPolymorphicTypeValidator() instanceof com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator);
        assertTrue(this.objectMapper
                .getDeserializationContext() instanceof com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl);
        JsonFactory factory = this.objectMapper.getFactory();
        assertTrue(factory instanceof MappingJsonFactory);
        assertSame(factory, this.objectMapper.getJsonFactory());
        assertTrue(this.objectMapper
                .getSerializerProviderInstance() instanceof com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl);
        assertTrue(this.objectMapper.getVisibilityChecker() instanceof VisibilityChecker.Std);
        assertNull(this.objectMapper.getPropertyNamingStrategy());
        assertTrue(this.objectMapper
                .getSerializerProvider() instanceof com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl);
        assertTrue(this.objectMapper
                .getSubtypeResolver() instanceof com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver);
    }
}

