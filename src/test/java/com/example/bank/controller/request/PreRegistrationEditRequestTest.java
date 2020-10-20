package com.example.bank.controller.request;

import com.example.bank.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PreRegistrationEditRequestTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new PreRegistrationEditRequest()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        PreRegistrationEditRequest actualPreRegistrationEditRequest = new PreRegistrationEditRequest();

        // Assert
        assertNull(actualPreRegistrationEditRequest.getLastName());
        assertNull(actualPreRegistrationEditRequest.getStatus());
        assertNull(actualPreRegistrationEditRequest.getBirthDate());
        assertNull(actualPreRegistrationEditRequest.getEmail());
        assertNull(actualPreRegistrationEditRequest.getId());
        assertNull(actualPreRegistrationEditRequest.getFirstName());
        assertNull(actualPreRegistrationEditRequest.getCpf());
        assertEquals(
                "PreRegistrationEditRequest(id=null, firstName=null, lastName=null, email=null, birthDate=null, cpf=null,"
                        + " status=null)",
                actualPreRegistrationEditRequest.toString());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new PreRegistrationEditRequest()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();

        // Act and Assert
        assertTrue(preRegistrationEditRequest.equals(new PreRegistrationEditRequest()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setLastName("Doe");

        // Act and Assert
        assertFalse(preRegistrationEditRequest.equals(new PreRegistrationEditRequest()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setFirstName("Jane");

        // Act and Assert
        assertFalse(preRegistrationEditRequest.equals(new PreRegistrationEditRequest()));
    }

    @Test
    public void testEquals5() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setLastName("Doe");

        // Act and Assert
        assertFalse((new PreRegistrationEditRequest()).equals(preRegistrationEditRequest));
    }

    @Test
    public void testEquals6() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setFirstName("Jane");

        // Act and Assert
        assertFalse((new PreRegistrationEditRequest()).equals(preRegistrationEditRequest));
    }

    @Test
    public void testEquals7() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setStatus(Status.UNDER_PRE_ANALYSIS);

        // Act and Assert
        assertFalse(preRegistrationEditRequest.equals(new PreRegistrationEditRequest()));
    }

    @Test
    public void testEquals8() {
        // Arrange
        LocalDate birthDate = LocalDate.ofEpochDay(1L);
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setBirthDate(birthDate);

        // Act and Assert
        assertFalse(preRegistrationEditRequest.equals(new PreRegistrationEditRequest()));
    }

    @Test
    public void testEquals9() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setEmail("Email");

        // Act and Assert
        assertFalse(preRegistrationEditRequest.equals(new PreRegistrationEditRequest()));
    }

    @Test
    public void testGetBirthDate() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEditRequest()).getBirthDate());
    }

    @Test
    public void testGetCpf() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEditRequest()).getCpf());
    }

    @Test
    public void testGetEmail() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEditRequest()).getEmail());
    }

    @Test
    public void testGetFirstName() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEditRequest()).getFirstName());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEditRequest()).getId());
    }

    @Test
    public void testGetLastName() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEditRequest()).getLastName());
    }

    @Test
    public void testGetStatus() {
        // Arrange, Act and Assert
        assertNull((new PreRegistrationEditRequest()).getStatus());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(64204658, (new PreRegistrationEditRequest()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setLastName("Doe");

        // Act and Assert
        assertEquals(1084502001, preRegistrationEditRequest.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setFirstName("Jane");

        // Act and Assert
        assertEquals(1631957747, preRegistrationEditRequest.hashCode());
    }

    @Test
    public void testHashCode4() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setStatus(Status.UNDER_PRE_ANALYSIS);
        PreRegistrationEditRequest preRegistrationEditRequest1 = new PreRegistrationEditRequest();
        preRegistrationEditRequest1.setStatus(Status.UNDER_PRE_ANALYSIS);

        // Act and Assert
        assertEquals(preRegistrationEditRequest1.hashCode(), preRegistrationEditRequest.hashCode());
    }

    @Test
    public void testHashCode5() {
        // Arrange
        LocalDate birthDate = LocalDate.ofEpochDay(1L);
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setBirthDate(birthDate);

        // Act and Assert
        assertEquals(1223686193, preRegistrationEditRequest.hashCode());
    }

    @Test
    public void testHashCode6() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setEmail("Email");

        // Act and Assert
        assertEquals(196892581, preRegistrationEditRequest.hashCode());
    }

    @Test
    public void testHashCode7() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        preRegistrationEditRequest.setCpf("Cpf");

        // Act and Assert
        assertEquals(68211820, preRegistrationEditRequest.hashCode());
    }

    @Test
    public void testSetBirthDate() {
        // Arrange
        LocalDate birthDate = LocalDate.ofEpochDay(1L);
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();

        // Act
        preRegistrationEditRequest.setBirthDate(birthDate);

        // Assert
        assertEquals("PreRegistrationEditRequest(id=null, firstName=null, lastName=null, email=null, birthDate=1970-01-02,"
                + " cpf=null, status=null)", preRegistrationEditRequest.toString());
    }

    @Test
    public void testSetCpf() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();

        // Act
        preRegistrationEditRequest.setCpf("Cpf");

        // Assert
        assertEquals("Cpf", preRegistrationEditRequest.getCpf());
    }

    @Test
    public void testSetEmail() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();

        // Act
        preRegistrationEditRequest.setEmail("Email");

        // Assert
        assertEquals("Email", preRegistrationEditRequest.getEmail());
    }

    @Test
    public void testSetFirstName() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();

        // Act
        preRegistrationEditRequest.setFirstName("Jane");

        // Assert
        assertEquals("Jane", preRegistrationEditRequest.getFirstName());
    }

    @Test
    public void testSetId() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        preRegistrationEditRequest.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, preRegistrationEditRequest.getId());
    }

    @Test
    public void testSetLastName() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();

        // Act
        preRegistrationEditRequest.setLastName("Doe");

        // Assert
        assertEquals("Doe", preRegistrationEditRequest.getLastName());
    }

    @Test
    public void testSetStatus() {
        // Arrange
        PreRegistrationEditRequest preRegistrationEditRequest = new PreRegistrationEditRequest();

        // Act
        preRegistrationEditRequest.setStatus(Status.UNDER_PRE_ANALYSIS);

        // Assert
        assertEquals(Status.UNDER_PRE_ANALYSIS, preRegistrationEditRequest.getStatus());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "PreRegistrationEditRequest(id=null, firstName=null, lastName=null, email=null, birthDate=null, cpf=null,"
                        + " status=null)",
                (new PreRegistrationEditRequest()).toString());
    }
}

