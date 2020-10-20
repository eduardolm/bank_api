package com.example.bank.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {
    @Test
    public void testValueOf() {
        // Arrange, Act and Assert
        assertEquals(State.AC, State.valueOf("AC"));
    }

    @Test
    public void testValues() {
        // Arrange and Act
        State[] actualValuesResult = State.values();

        // Assert
        assertEquals(27, actualValuesResult.length);
        assertEquals(State.AC, actualValuesResult[0]);
        assertEquals(State.AL, actualValuesResult[1]);
        assertEquals(State.AP, actualValuesResult[2]);
        assertEquals(State.AM, actualValuesResult[3]);
        assertEquals(State.BA, actualValuesResult[4]);
        assertEquals(State.CE, actualValuesResult[5]);
        assertEquals(State.RO, actualValuesResult[21]);
        assertEquals(State.RR, actualValuesResult[22]);
        assertEquals(State.SC, actualValuesResult[23]);
        assertEquals(State.SP, actualValuesResult[24]);
        assertEquals(State.SE, actualValuesResult[25]);
        assertEquals(State.TO, actualValuesResult[26]);
    }
}

