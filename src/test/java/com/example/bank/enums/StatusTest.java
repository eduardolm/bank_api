package com.example.bank.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {
    @Test
    public void testValueOf() {
        // Arrange, Act and Assert
        assertEquals(Status.APPROVED, Status.valueOf("APPROVED"));
    }

    @Test
    public void testValues() {
        // Arrange, Act and Assert
        assertEquals(9, Status.values().length);
    }
}

