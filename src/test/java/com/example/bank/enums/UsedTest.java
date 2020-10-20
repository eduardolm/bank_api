package com.example.bank.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsedTest {
    @Test
    public void testValueOf() {
        // Arrange, Act and Assert
        assertEquals(Used.NO, Used.valueOf("NO"));
    }

    @Test
    public void testValues() {
        // Arrange, Act and Assert
        assertEquals(2, Used.values().length);
    }
}

