package com.example.bank.entity;

import com.example.bank.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PreRegistrationEntityTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new PreRegistrationEntity()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        PreRegistrationEntity actualPreRegistrationEntity = new PreRegistrationEntity();

        // Assert
        assertNull(actualPreRegistrationEntity.getLastName());
        assertNull(actualPreRegistrationEntity.getStatus());
        assertNull(actualPreRegistrationEntity.getBirthDate());
        assertNull(actualPreRegistrationEntity.getEmail());
        assertNull(actualPreRegistrationEntity.getId());
        assertNull(actualPreRegistrationEntity.getFirstName());
        assertNull(actualPreRegistrationEntity.getCpf());
        assertEquals("PreRegistrationEntity(id=null, firstName=null, lastName=null, email=null, birthDate=null, cpf=null,"
                + " status=null)", actualPreRegistrationEntity.toString());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new PreRegistrationEntity()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");

        // Act and Assert
        assertFalse((new PreRegistrationEntity()).equals(preRegistrationEntity));
    }

    @Test
    public void testEquals3() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");

        // Act and Assert
        assertFalse((new PreRegistrationEntity()).equals(preRegistrationEntity));
    }

    @Test
    public void testEquals4() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName(null);

        // Act and Assert
        assertFalse((new PreRegistrationEntity()).equals(preRegistrationEntity));
    }

    @Test
    public void testEquals5() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setFirstName("Jane");
        PreRegistrationEntity preRegistrationEntity1 = new PreRegistrationEntity();
        preRegistrationEntity1.setLastName("Doe");
        preRegistrationEntity1.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity1.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity1.setEmail("Email");
        preRegistrationEntity1.setId(null);
        preRegistrationEntity1.setCpf("Cpf");
        preRegistrationEntity1.setFirstName("Jane");

        // Act and Assert
        assertFalse(preRegistrationEntity.equals(preRegistrationEntity1));
    }

    @Test
    public void testEquals6() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName(null);
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName(null);

        // Act and Assert
        assertFalse((new PreRegistrationEntity()).equals(preRegistrationEntity));
    }

    @Test
    public void testEquals7() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setFirstName("First Name");
        PreRegistrationEntity preRegistrationEntity1 = new PreRegistrationEntity();
        preRegistrationEntity1.setLastName("Doe");
        preRegistrationEntity1.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity1.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity1.setEmail("Email");
        preRegistrationEntity1.setId(null);
        preRegistrationEntity1.setCpf("Cpf");
        preRegistrationEntity1.setFirstName("Jane");

        // Act and Assert
        assertFalse(preRegistrationEntity.equals(preRegistrationEntity1));
    }

    @Test
    public void testEquals8() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        PreRegistrationEntity preRegistrationEntity1 = new PreRegistrationEntity();
        preRegistrationEntity1.setLastName("Doe");
        preRegistrationEntity1.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity1.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity1.setEmail("Email");
        preRegistrationEntity1.setId(null);
        preRegistrationEntity1.setCpf("Cpf");
        preRegistrationEntity1.setFirstName(null);

        // Act and Assert
        assertFalse(preRegistrationEntity.equals(preRegistrationEntity1));
    }

    @Test
    public void testEquals9() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName(null);
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail(null);
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName(null);

        // Act and Assert
        assertFalse((new PreRegistrationEntity()).equals(preRegistrationEntity));
    }

    @Test
    public void testGetBirthDate() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEntity()).getBirthDate());
    }

    @Test
    public void testGetCpf() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEntity()).getCpf());
    }

    @Test
    public void testGetEmail() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEntity()).getEmail());
    }

    @Test
    public void testGetFirstName() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEntity()).getFirstName());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEntity()).getId());
    }

    @Test
    public void testGetLastName() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEntity()).getLastName());
    }

    @Test
    public void testGetStatus() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEntity()).getStatus());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(64204658, (new PreRegistrationEntity()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");

        // Act and Assert
        assertEquals(1084502001, preRegistrationEntity.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setFirstName("Jane");

        // Act and Assert
        assertEquals(1631957747, preRegistrationEntity.hashCode());
    }

    @Test
    public void testHashCode4() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        PreRegistrationEntity preRegistrationEntity1 = new PreRegistrationEntity();
        preRegistrationEntity1.setStatus(Status.UNDER_PRE_ANALYSIS);

        // Act and Assert
        assertEquals(preRegistrationEntity1.hashCode(), preRegistrationEntity.hashCode());
    }

    @Test
    public void testHashCode5() {
        // Arrange
        LocalDate birthDate = LocalDate.ofEpochDay(1L);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setBirthDate(birthDate);

        // Act and Assert
        assertEquals(1223686193, preRegistrationEntity.hashCode());
    }

    @Test
    public void testHashCode6() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setEmail("Email");

        // Act and Assert
        assertEquals(196892581, preRegistrationEntity.hashCode());
    }

    @Test
    public void testHashCode7() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setCpf("Cpf");

        // Act and Assert
        assertEquals(68211820, preRegistrationEntity.hashCode());
    }

    @Test
    public void testSetBirthDate() {
        // Arrange
        LocalDate birthDate = LocalDate.ofEpochDay(1L);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();

        // Act
        preRegistrationEntity.setBirthDate(birthDate);

        // Assert
        assertEquals(
                "PreRegistrationEntity(id=null, firstName=null, lastName=null, email=null, birthDate=1970-01-02, cpf=null,"
                        + " status=null)",
                preRegistrationEntity.toString());
    }

    @Test
    public void testSetCpf() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();

        // Act
        preRegistrationEntity.setCpf("Cpf");

        // Assert
        assertEquals("Cpf", preRegistrationEntity.getCpf());
    }

    @Test
    public void testSetEmail() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();

        // Act
        preRegistrationEntity.setEmail("Email");

        // Assert
        assertEquals("Email", preRegistrationEntity.getEmail());
    }

    @Test
    public void testSetFirstName() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();

        // Act
        preRegistrationEntity.setFirstName("Jane");

        // Assert
        assertEquals("Jane", preRegistrationEntity.getFirstName());
    }

    @Test
    public void testSetId() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        preRegistrationEntity.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, preRegistrationEntity.getId());
    }

    @Test
    public void testSetLastName() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();

        // Act
        preRegistrationEntity.setLastName("Doe");

        // Assert
        assertEquals("Doe", preRegistrationEntity.getLastName());
    }

    @Test
    public void testSetStatus() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();

        // Act
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);

        // Assert
        assertEquals(Status.UNDER_PRE_ANALYSIS, preRegistrationEntity.getStatus());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("PreRegistrationEntity(id=null, firstName=null, lastName=null, email=null, birthDate=null, cpf=null,"
                + " status=null)", (new PreRegistrationEntity()).toString());
    }
}

