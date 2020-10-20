package com.example.bank.entity;

import com.example.bank.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordEntityTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new PasswordEntity()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        PasswordEntity actualPasswordEntity = new PasswordEntity();

        // Assert
        assertNull(actualPasswordEntity.getProposal());
        assertNull(actualPasswordEntity.getId());
        assertEquals("PasswordEntity(id=null, password=null, proposal=null)", actualPasswordEntity.toString());
        assertNull(actualPasswordEntity.getPassword());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new PasswordEntity()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setPassword("iloveyou");
        passwordEntity.setId(UUID.randomUUID());
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        passwordEntity.setProposal(preRegistrationEntity);

        // Act and Assert
        assertFalse((new PasswordEntity()).equals(passwordEntity));
    }

    @Test
    public void testEquals3() {
        // Arrange
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setPassword("iloveyou");
        passwordEntity.setId(null);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        passwordEntity.setProposal(preRegistrationEntity);

        // Act and Assert
        assertFalse((new PasswordEntity()).equals(passwordEntity));
    }

    @Test
    public void testEquals4() {
        // Arrange
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setPassword(null);
        passwordEntity.setId(null);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        passwordEntity.setProposal(preRegistrationEntity);

        // Act and Assert
        assertFalse((new PasswordEntity()).equals(passwordEntity));
    }

    @Test
    public void testEquals5() {
        // Arrange
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setPassword("iloveyou");
        PasswordEntity passwordEntity1 = new PasswordEntity();
        passwordEntity1.setPassword("iloveyou");
        passwordEntity1.setId(null);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        passwordEntity1.setProposal(preRegistrationEntity);

        // Act and Assert
        assertFalse(passwordEntity.equals(passwordEntity1));
    }

    @Test
    public void testEquals6() {
        // Arrange
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setPassword("Password");
        PasswordEntity passwordEntity1 = new PasswordEntity();
        passwordEntity1.setPassword("iloveyou");
        passwordEntity1.setId(null);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        passwordEntity1.setProposal(preRegistrationEntity);

        // Act and Assert
        assertFalse(passwordEntity.equals(passwordEntity1));
    }

    @Test
    public void testEquals7() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(null);
        preRegistrationEntity.setBirthDate(null);
        preRegistrationEntity.setEmail(null);
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf(null);
        preRegistrationEntity.setFirstName("Jane");
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setProposal(preRegistrationEntity);
        PasswordEntity passwordEntity1 = new PasswordEntity();
        passwordEntity1.setPassword(null);
        passwordEntity1.setId(null);
        PreRegistrationEntity preRegistrationEntity1 = new PreRegistrationEntity();
        preRegistrationEntity1.setLastName("Doe");
        preRegistrationEntity1.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity1.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity1.setEmail("Email");
        preRegistrationEntity1.setId(UUID.randomUUID());
        preRegistrationEntity1.setCpf("Cpf");
        preRegistrationEntity1.setFirstName("Jane");
        passwordEntity1.setProposal(preRegistrationEntity1);

        // Act and Assert
        assertFalse(passwordEntity.equals(passwordEntity1));
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new PasswordEntity()).getId());
    }

    @Test
    public void testGetPassword() {
        // Arrange, Act and Assert
        assertNull((new PasswordEntity()).getPassword());
    }

    @Test
    public void testGetProposal() {
        // Arrange, Act and Assert
        assertNull((new PasswordEntity()).getProposal());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(357642, (new PasswordEntity()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setPassword("iloveyou");

        // Act and Assert
        assertEquals(-1302945363, passwordEntity.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(null);
        preRegistrationEntity.setBirthDate(null);
        preRegistrationEntity.setEmail(null);
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf(null);
        preRegistrationEntity.setFirstName("Jane");
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setProposal(preRegistrationEntity);

        // Act and Assert
        assertEquals(-1642354607, passwordEntity.hashCode());
    }

    @Test
    public void testSetId() {
        // Arrange
        PasswordEntity passwordEntity = new PasswordEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        passwordEntity.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, passwordEntity.getId());
    }

    @Test
    public void testSetPassword() {
        // Arrange
        PasswordEntity passwordEntity = new PasswordEntity();

        // Act
        passwordEntity.setPassword("iloveyou");

        // Assert
        assertEquals("iloveyou", passwordEntity.getPassword());
    }

    @Test
    public void testSetProposal() {
        // Arrange
        PasswordEntity passwordEntity = new PasswordEntity();

        // Act
        passwordEntity.setProposal(new PreRegistrationEntity());

        // Assert
        assertEquals("PasswordEntity(id=null, password=null, proposal=PreRegistrationEntity(id=null, firstName=null,"
                + " lastName=null, email=null, birthDate=null, cpf=null, status=null))", passwordEntity.toString());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("PasswordEntity(id=null, password=null, proposal=null)", (new PasswordEntity()).toString());
    }
}

