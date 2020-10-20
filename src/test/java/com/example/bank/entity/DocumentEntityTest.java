package com.example.bank.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentEntityTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new DocumentEntity()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        DocumentEntity actualDocumentEntity = new DocumentEntity();

        // Assert
        assertEquals("DocumentEntity(id=null, imageAddress=null)", actualDocumentEntity.toString());
        assertNull(actualDocumentEntity.getImageAddress());
        assertNull(actualDocumentEntity.getId());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new DocumentEntity()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse((new DocumentEntity()).equals(documentEntity));
    }

    @Test
    public void testEquals3() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(null);

        // Act and Assert
        assertFalse((new DocumentEntity()).equals(documentEntity));
    }

    @Test
    public void testEquals4() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress(null);
        documentEntity.setId(null);

        // Act and Assert
        assertTrue((new DocumentEntity()).equals(documentEntity));
    }

    @Test
    public void testEquals5() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        DocumentEntity documentEntity1 = new DocumentEntity();
        documentEntity1.setImageAddress("42 Main St");
        documentEntity1.setId(null);

        // Act and Assert
        assertTrue(documentEntity.equals(documentEntity1));
    }

    @Test
    public void testEquals6() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("Image Address");
        DocumentEntity documentEntity1 = new DocumentEntity();
        documentEntity1.setImageAddress("42 Main St");
        documentEntity1.setId(null);

        // Act and Assert
        assertFalse(documentEntity.equals(documentEntity1));
    }

    @Test
    public void testEquals7() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setId(UUID.randomUUID());
        DocumentEntity documentEntity1 = new DocumentEntity();
        documentEntity1.setImageAddress("42 Main St");
        documentEntity1.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse(documentEntity.equals(documentEntity1));
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new DocumentEntity()).getId());
    }

    @Test
    public void testGetImageAddress() {
        // Arrange, Act and Assert
        assertNull((new DocumentEntity()).getImageAddress());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(6061, (new DocumentEntity()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");

        // Act and Assert
        assertEquals(623798792, documentEntity.hashCode());
    }

    @Test
    public void testSetId() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        documentEntity.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, documentEntity.getId());
    }

    @Test
    public void testSetImageAddress() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();

        // Act
        documentEntity.setImageAddress("42 Main St");

        // Assert
        assertEquals("42 Main St", documentEntity.getImageAddress());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("DocumentEntity(id=null, imageAddress=null)", (new DocumentEntity()).toString());
    }
}

