package com.example.bank.dto;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class RequestTokenTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new RequestToken()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        RequestToken actualRequestToken = new RequestToken();

        // Assert
        assertEquals("RequestToken(id=null, email=null, cpf=null)", actualRequestToken.toString());
        assertNull(actualRequestToken.getEmail());
        assertNull(actualRequestToken.getId());
        assertNull(actualRequestToken.getCpf());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new RequestToken()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        RequestToken requestToken = new RequestToken();

        // Act and Assert
        assertTrue(requestToken.equals(new RequestToken()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        RequestToken requestToken = new RequestToken();
        requestToken.setEmail("Email");

        // Act and Assert
        assertFalse(requestToken.equals(new RequestToken()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        RequestToken requestToken = new RequestToken();
        requestToken.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse(requestToken.equals(new RequestToken()));
    }

    @Test
    public void testEquals5() {
        // Arrange
        RequestToken requestToken = new RequestToken();
        requestToken.setCpf("Cpf");

        // Act and Assert
        assertFalse(requestToken.equals(new RequestToken()));
    }

    @Test
    public void testEquals6() {
        // Arrange
        RequestToken requestToken = new RequestToken();
        requestToken.setEmail("Email");

        // Act and Assert
        assertFalse((new RequestToken()).equals(requestToken));
    }

    @Test
    public void testEquals7() {
        // Arrange
        RequestToken requestToken = new RequestToken();
        requestToken.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse((new RequestToken()).equals(requestToken));
    }

    @Test
    public void testEquals8() {
        // Arrange
        RequestToken requestToken = new RequestToken();
        requestToken.setCpf("Cpf");

        // Act and Assert
        assertFalse((new RequestToken()).equals(requestToken));
    }

    @Test
    public void testGetCpf() {
        // Arrange, Act and Assert
        assertNull((new RequestToken()).getCpf());
    }

    @Test
    public void testGetEmail() {
        // Arrange, Act and Assert
        assertNull((new RequestToken()).getEmail());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new RequestToken()).getId());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(357642, (new RequestToken()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        RequestToken requestToken = new RequestToken();
        requestToken.setEmail("Email");

        // Act and Assert
        assertEquals(-337674059, requestToken.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        RequestToken requestToken = new RequestToken();
        requestToken.setCpf("Cpf");

        // Act and Assert
        assertEquals(425560, requestToken.hashCode());
    }

    @Test
    public void testSetCpf() {
        // Arrange
        RequestToken requestToken = new RequestToken();

        // Act
        requestToken.setCpf("Cpf");

        // Assert
        assertEquals("Cpf", requestToken.getCpf());
    }

    @Test
    public void testSetEmail() {
        // Arrange
        RequestToken requestToken = new RequestToken();

        // Act
        requestToken.setEmail("Email");

        // Assert
        assertEquals("Email", requestToken.getEmail());
    }

    @Test
    public void testSetId() {
        // Arrange
        RequestToken requestToken = new RequestToken();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        requestToken.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, requestToken.getId());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("RequestToken(id=null, email=null, cpf=null)", (new RequestToken()).toString());
    }
}

