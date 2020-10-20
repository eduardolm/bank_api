package com.example.bank.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {HttpMessageNotReadableExceptionHandler.class})
@ExtendWith(SpringExtension.class)
public class HttpMessageNotReadableExceptionHandlerTest {
    @Autowired
    private HttpMessageNotReadableExceptionHandler httpMessageNotReadableExceptionHandler;

    @Test
    public void testHandleHttpMessageNotReadableException() {
        // Arrange and Act
        ResponseEntity actualHandleHttpMessageNotReadableExceptionResult = this.httpMessageNotReadableExceptionHandler
                .handleHttpMessageNotReadableException(new HttpMessageNotReadableException("https://example.org/example"));

        // Assert
        assertEquals(
                "<400 BAD_REQUEST Bad Request,{\"Message\":\"Estado inválido. Favor verificar.\",\"Erro\":\"Bad Request\",\"Code"
                        + "\":400},[]>",
                actualHandleHttpMessageNotReadableExceptionResult.toString());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleHttpMessageNotReadableExceptionResult.getStatusCode());
        assertTrue(actualHandleHttpMessageNotReadableExceptionResult.hasBody());
    }
}

