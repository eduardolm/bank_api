package com.example.bank.dto;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new Password()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        Password actualPassword = new Password();

        // Assert
        assertNull(actualPassword.getPassword());
        assertNull(actualPassword.getId());
        assertEquals("Password(id=null, password=null)", actualPassword.toString());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new Password()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        Password password = new Password();

        // Act and Assert
        assertTrue(password.equals(new Password()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        Password password = new Password();
        password.setPassword("iloveyou");

        // Act and Assert
        assertFalse(password.equals(new Password()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        Password password = new Password();
        password.setPassword("iloveyou");

        // Act and Assert
        assertFalse((new Password()).equals(password));
    }

    @Test
    public void testEquals5() {
        // Arrange
        Password password = new Password();
        password.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse(password.equals(new Password()));
    }

    @Test
    public void testEquals6() {
        // Arrange
        Password password = new Password();
        password.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse((new Password()).equals(password));
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new Password()).getId());
    }

    @Test
    public void testGetPassword() {
        // Arrange, Act and Assert
        assertNull((new Password()).getPassword());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(6061, (new Password()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        Password password = new Password();
        password.setPassword("iloveyou");

        // Act and Assert
        assertEquals(-1332412826, password.hashCode());
    }

    @Test
    public void testSetId() {
        // Arrange
        Password password = new Password();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        password.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, password.getId());
    }

    @Test
    public void testSetPassword() {
        // Arrange
        Password password = new Password();

        // Act
        password.setPassword("iloveyou");

        // Assert
        assertEquals("iloveyou", password.getPassword());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("Password(id=null, password=null)", (new Password()).toString());
    }
}

