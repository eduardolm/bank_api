package com.example.bank.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TokenTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new Token()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        Token actualToken = new Token();

        // Assert
        assertEquals("Token(id=null, token=null, expires=null, used=null)", actualToken.toString());
        assertNull(actualToken.getToken());
        assertNull(actualToken.getExpires());
        assertNull(actualToken.getUsed());
        assertNull(actualToken.getId());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new Token()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        Token token = new Token();

        // Act and Assert
        assertTrue(token.equals(new Token()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        Token token = new Token();
        token.setToken("ABC123");

        // Act and Assert
        assertFalse(token.equals(new Token()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        Token token = new Token();
        token.setToken("ABC123");

        // Act and Assert
        assertFalse((new Token()).equals(token));
    }

    @Test
    public void testEquals5() {
        // Arrange
        Token token = new Token();
        token.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse(token.equals(new Token()));
    }

    @Test
    public void testEquals6() {
        // Arrange
        LocalDateTime expires = LocalDateTime.of(1, 1, 1, 1, 1);
        Token token = new Token();
        token.setExpires(expires);

        // Act and Assert
        assertFalse(token.equals(new Token()));
    }

    @Test
    public void testEquals7() {
        // Arrange
        Token token = new Token();
        token.setUsed("Used");

        // Act and Assert
        assertFalse(token.equals(new Token()));
    }

    @Test
    public void testEquals8() {
        // Arrange
        Token token = new Token();
        token.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse((new Token()).equals(token));
    }

    @Test
    public void testEquals9() {
        // Arrange
        LocalDateTime expires = LocalDateTime.of(1, 1, 1, 1, 1);
        Token token = new Token();
        token.setExpires(expires);

        // Act and Assert
        assertFalse((new Token()).equals(token));
    }

    @Test
    public void testGetExpires() {
        // Arrange, Act and Assert
        assertNull((new Token()).getExpires());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new Token()).getId());
    }

    @Test
    public void testGetToken() {
        // Arrange, Act and Assert
        assertNull((new Token()).getToken());
    }

    @Test
    public void testGetUsed() {
        // Arrange, Act and Assert
        assertNull((new Token()).getUsed());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(21100921, (new Token()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        Token token = new Token();
        token.setToken("ABC123");

        // Act and Assert
        assertEquals(1234598902, token.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        LocalDateTime expires = LocalDateTime.of(1, 1, 1, 1, 1);
        Token token = new Token();
        token.setExpires(expires);

        // Act and Assert
        assertEquals(1950283111, token.hashCode());
    }

    @Test
    public void testHashCode4() {
        // Arrange
        Token token = new Token();
        token.setUsed("Used");

        // Act and Assert
        assertEquals(23746859, token.hashCode());
    }

    @Test
    public void testSetId() {
        // Arrange
        Token token = new Token();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        token.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, token.getId());
    }

    @Test
    public void testSetToken() {
        // Arrange
        Token token = new Token();

        // Act
        token.setToken("ABC123");

        // Assert
        assertEquals("ABC123", token.getToken());
    }

    @Test
    public void testSetUsed() {
        // Arrange
        Token token = new Token();

        // Act
        token.setUsed("Used");

        // Assert
        assertEquals("Used", token.getUsed());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("Token(id=null, token=null, expires=null, used=null)", (new Token()).toString());
    }
}

