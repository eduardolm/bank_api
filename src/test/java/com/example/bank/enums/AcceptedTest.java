package com.example.bank.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptedTest {
    @Test
    public void testValueOf() {
        // Arrange, Act and Assert
        assertEquals(Accepted.NO, Accepted.valueOf("NO"));
    }

    @Test
    public void testValues() {
        // Arrange, Act and Assert
        assertEquals(2, Accepted.values().length);
    }
}

