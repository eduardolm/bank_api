package com.example.bank.dto;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new Document()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        Document actualDocument = new Document();

        // Assert
        assertEquals("Document(id=null, imageAddress=null)", actualDocument.toString());
        assertNull(actualDocument.getImageAddress());
        assertNull(actualDocument.getId());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new Document()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        Document document = new Document();

        // Act and Assert
        assertTrue(document.equals(new Document()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        Document document = new Document();
        document.setImageAddress("42 Main St");

        // Act and Assert
        assertFalse(document.equals(new Document()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        Document document = new Document();
        document.setImageAddress("42 Main St");

        // Act and Assert
        assertFalse((new Document()).equals(document));
    }

    @Test
    public void testEquals5() {
        // Arrange
        Document document = new Document();
        document.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse(document.equals(new Document()));
    }

    @Test
    public void testEquals6() {
        // Arrange
        Document document = new Document();
        document.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse((new Document()).equals(document));
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new Document()).getId());
    }

    @Test
    public void testGetImageAddress() {
        // Arrange, Act and Assert
        assertNull((new Document()).getImageAddress());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(6061, (new Document()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        Document document = new Document();
        document.setImageAddress("42 Main St");

        // Act and Assert
        assertEquals(623798792, document.hashCode());
    }

    @Test
    public void testSetId() {
        // Arrange
        Document document = new Document();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        document.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, document.getId());
    }

    @Test
    public void testSetImageAddress() {
        // Arrange
        Document document = new Document();

        // Act
        document.setImageAddress("42 Main St");

        // Assert
        assertEquals("42 Main St", document.getImageAddress());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("Document(id=null, imageAddress=null)", (new Document()).toString());
    }
}

