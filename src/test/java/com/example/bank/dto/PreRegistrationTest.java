package com.example.bank.dto;

import com.example.bank.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PreRegistrationTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new PreRegistration()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange, Act and Assert
        assertEquals(Status.UNDER_PRE_ANALYSIS, (new PreRegistration()).getStatus());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new PreRegistration()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();

        // Act and Assert
        assertTrue(preRegistration.equals(new PreRegistration()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setLastName("Doe");

        // Act and Assert
        assertFalse(preRegistration.equals(new PreRegistration()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setStatus(null);

        // Act and Assert
        assertFalse(preRegistration.equals(new PreRegistration()));
    }

    @Test
    public void testEquals5() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setFirstName("Jane");

        // Act and Assert
        assertFalse(preRegistration.equals(new PreRegistration()));
    }

    @Test
    public void testEquals6() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setLastName("Doe");

        // Act and Assert
        assertFalse((new PreRegistration()).equals(preRegistration));
    }

    @Test
    public void testEquals7() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setStatus(null);

        // Act and Assert
        assertFalse((new PreRegistration()).equals(preRegistration));
    }

    @Test
    public void testEquals8() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setFirstName("Jane");

        // Act and Assert
        assertFalse((new PreRegistration()).equals(preRegistration));
    }

    @Test
    public void testEquals9() {
        // Arrange
        LocalDate birthDate = LocalDate.ofEpochDay(1L);
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setBirthDate(birthDate);

        // Act and Assert
        assertFalse(preRegistration.equals(new PreRegistration()));
    }

    @Test
    public void testGetBirthDate() {
        // Arrange, Act and Assert
        assertNull((new PreRegistration()).getBirthDate());
    }

    @Test
    public void testGetCpf() {
        // Arrange, Act and Assert
        assertNull((new PreRegistration()).getCpf());
    }

    @Test
    public void testGetEmail() {
        // Arrange, Act and Assert
        assertNull((new PreRegistration()).getEmail());
    }

    @Test
    public void testGetFirstName() {
        // Arrange, Act and Assert
        assertNull((new PreRegistration()).getFirstName());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new PreRegistration()).getId());
    }

    @Test
    public void testGetLastName() {
        // Arrange, Act and Assert
        assertNull((new PreRegistration()).getLastName());
    }

    @Test
    public void testGetStatus() {
        // Arrange, Act and Assert
        assertEquals(Status.UNDER_PRE_ANALYSIS, (new PreRegistration()).getStatus());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        int test1 = new PreRegistration().hashCode();
        int test2 = new PreRegistration().hashCode();
        assertEquals(test2, test1);
    }

    @Test
    public void testHashCode2() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setLastName("Doe");

        PreRegistration preRegistration1 = new PreRegistration();
        preRegistration1.setLastName("Doe");

        // Act and Assert
        assertEquals(preRegistration1.hashCode(), preRegistration.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setStatus(null);

        // Act and Assert
        assertEquals(64204658, preRegistration.hashCode());
    }

    @Test
    public void testHashCode4() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setFirstName("Jane");
        PreRegistration preRegistration1 = new PreRegistration();
        preRegistration1.setFirstName("Jane");

        // Act and Assert
        assertEquals(preRegistration1.hashCode(), preRegistration.hashCode());
    }

    @Test
    public void testHashCode5() {
        // Arrange
        LocalDate birthDate = LocalDate.ofEpochDay(1L);
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setBirthDate(birthDate);
        PreRegistration preRegistration1 = new PreRegistration();
        preRegistration1.setBirthDate(birthDate);

        // Act and Assert
        assertEquals(preRegistration1.hashCode(), preRegistration.hashCode());
    }

    @Test
    public void testHashCode6() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setEmail("Email");
        PreRegistration preRegistration1 = new PreRegistration();
        preRegistration1.setEmail("Email");

        // Act and Assert
        assertEquals(preRegistration1.hashCode(), preRegistration.hashCode());
    }

    @Test
    public void testHashCode7() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        preRegistration.setCpf("Cpf");
        PreRegistration preRegistration1 = new PreRegistration();
        preRegistration1.setCpf("Cpf");

        // Act and Assert
        assertEquals(preRegistration1.hashCode(), preRegistration.hashCode());
    }

    @Test
    public void testSetBirthDate() {
        // Arrange
        LocalDate birthDate = LocalDate.ofEpochDay(1L);
        PreRegistration preRegistration = new PreRegistration();

        // Act
        preRegistration.setBirthDate(birthDate);

        // Assert
        assertEquals("PreRegistration(id=null, firstName=null, lastName=null, email=null, birthDate=1970-01-02, cpf=null,"
                + " status=UNDER_PRE_ANALYSIS)", preRegistration.toString());
    }

    @Test
    public void testSetCpf() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();

        // Act
        preRegistration.setCpf("Cpf");

        // Assert
        assertEquals("Cpf", preRegistration.getCpf());
    }

    @Test
    public void testSetEmail() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();

        // Act
        preRegistration.setEmail("Email");

        // Assert
        assertEquals("Email", preRegistration.getEmail());
    }

    @Test
    public void testSetFirstName() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();

        // Act
        preRegistration.setFirstName("Jane");

        // Assert
        assertEquals("Jane", preRegistration.getFirstName());
    }

    @Test
    public void testSetId() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        preRegistration.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, preRegistration.getId());
    }

    @Test
    public void testSetLastName() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();

        // Act
        preRegistration.setLastName("Doe");

        // Assert
        assertEquals("Doe", preRegistration.getLastName());
    }

    @Test
    public void testSetStatus() {
        // Arrange
        PreRegistration preRegistration = new PreRegistration();

        // Act
        preRegistration.setStatus(Status.UNDER_PRE_ANALYSIS);

        // Assert
        assertEquals(Status.UNDER_PRE_ANALYSIS, preRegistration.getStatus());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("PreRegistration(id=null, firstName=null, lastName=null, email=null, birthDate=null, cpf=null,"
                + " status=UNDER_PRE_ANALYSIS)", (new PreRegistration()).toString());
    }
}

