package com.example.bank.entity;

import com.example.bank.enums.Status;
import com.example.bank.enums.Used;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TokenEntityTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new TokenEntity()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        TokenEntity actualTokenEntity = new TokenEntity();

        // Assert
        assertNull(actualTokenEntity.getProposal());
        assertNull(actualTokenEntity.getToken());
        assertNull(actualTokenEntity.getUsed());
        assertNull(actualTokenEntity.getExpires());
        assertNull(actualTokenEntity.getId());
        assertEquals("TokenEntity(id=null, token=null, expires=null, used=null, proposal=null)",
                actualTokenEntity.toString());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new TokenEntity()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setId(UUID.randomUUID());
        tokenEntity.setExpires(LocalDateTime.of(1, 1, 1, 1, 1));
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        tokenEntity.setProposal(preRegistrationEntity);
        tokenEntity.setToken("ABC123");
        tokenEntity.setUsed(Used.YES);

        // Act and Assert
        assertFalse((new TokenEntity()).equals(tokenEntity));
    }

    @Test
    public void testEquals3() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setId(null);
        tokenEntity.setExpires(LocalDateTime.of(1, 1, 1, 1, 1));
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        tokenEntity.setProposal(preRegistrationEntity);
        tokenEntity.setToken("ABC123");
        tokenEntity.setUsed(Used.YES);

        // Act and Assert
        assertFalse((new TokenEntity()).equals(tokenEntity));
    }

    @Test
    public void testEquals4() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setId(null);
        tokenEntity.setExpires(LocalDateTime.of(1, 1, 1, 1, 1));
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        tokenEntity.setProposal(preRegistrationEntity);
        tokenEntity.setToken(null);
        tokenEntity.setUsed(Used.YES);

        // Act and Assert
        assertFalse((new TokenEntity()).equals(tokenEntity));
    }

    @Test
    public void testEquals5() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setToken("ABC123");
        TokenEntity tokenEntity1 = new TokenEntity();
        tokenEntity1.setId(null);
        tokenEntity1.setExpires(LocalDateTime.of(1, 1, 1, 1, 1));
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        tokenEntity1.setProposal(preRegistrationEntity);
        tokenEntity1.setToken("ABC123");
        tokenEntity1.setUsed(Used.YES);

        // Act and Assert
        assertFalse(tokenEntity.equals(tokenEntity1));
    }

    @Test
    public void testEquals6() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setId(null);
        tokenEntity.setExpires(null);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        tokenEntity.setProposal(preRegistrationEntity);
        tokenEntity.setToken(null);
        tokenEntity.setUsed(Used.YES);

        // Act and Assert
        assertFalse((new TokenEntity()).equals(tokenEntity));
    }

    @Test
    public void testGetExpires() {
        // Arrange, Act and Assert
        assertNull((new TokenEntity()).getExpires());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new TokenEntity()).getId());
    }

    @Test
    public void testGetProposal() {
        // Arrange, Act and Assert
        assertNull((new TokenEntity()).getProposal());
    }

    @Test
    public void testGetToken() {
        // Arrange, Act and Assert
        assertNull((new TokenEntity()).getToken());
    }

    @Test
    public void testGetUsed() {
        // Arrange, Act and Assert
        assertNull((new TokenEntity()).getUsed());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(1244954382, (new TokenEntity()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(null);
        preRegistrationEntity.setBirthDate(null);
        preRegistrationEntity.setEmail(null);
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf(null);
        preRegistrationEntity.setFirstName("Jane");
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setProposal(preRegistrationEntity);

        // Act and Assert
        assertEquals(-397757867, tokenEntity.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setToken("ABC123");

        // Act and Assert
        assertEquals(-173108771, tokenEntity.hashCode());
    }

    @Test
    public void testHashCode4() {
        // Arrange
        LocalDateTime expires = LocalDateTime.of(1, 1, 1, 1, 1);
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setExpires(expires);

        // Act and Assert
        assertEquals(-897413400, tokenEntity.hashCode());
    }

    @Test
    public void testHashCode5() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUsed(Used.YES);
        TokenEntity tokenEntity1 = new TokenEntity();
        tokenEntity1.setUsed(Used.YES);

        // Act and Assert
        assertEquals(tokenEntity1.hashCode(), tokenEntity.hashCode());
    }

    @Test
    public void testSetId() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        tokenEntity.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, tokenEntity.getId());
    }

    @Test
    public void testSetProposal() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();

        // Act
        tokenEntity.setProposal(new PreRegistrationEntity());

        // Assert
        assertEquals(
                "TokenEntity(id=null, token=null, expires=null, used=null, proposal=PreRegistrationEntity(id=null,"
                        + " firstName=null, lastName=null, email=null, birthDate=null, cpf=null, status=null))",
                tokenEntity.toString());
    }

    @Test
    public void testSetToken() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();

        // Act
        tokenEntity.setToken("ABC123");

        // Assert
        assertEquals("ABC123", tokenEntity.getToken());
    }

    @Test
    public void testSetUsed() {
        // Arrange
        TokenEntity tokenEntity = new TokenEntity();

        // Act
        tokenEntity.setUsed(Used.YES);

        // Assert
        assertEquals(Used.YES, tokenEntity.getUsed());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("TokenEntity(id=null, token=null, expires=null, used=null, proposal=null)",
                (new TokenEntity()).toString());
    }
}

