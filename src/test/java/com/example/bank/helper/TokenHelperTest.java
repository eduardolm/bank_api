package com.example.bank.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenHelperTest {
    @Test
    public void testGenerateRandomToken() {
        // Arrange, Act and Assert
        assertEquals(2, (new TokenHelper()).generateRandomToken(3, true, true).size());
    }
}

