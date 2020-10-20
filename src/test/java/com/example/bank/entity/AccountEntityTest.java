package com.example.bank.entity;

import com.example.bank.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AccountEntityTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new AccountEntity()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        AccountEntity actualAccountEntity = new AccountEntity();

        // Assert
        assertNull(actualAccountEntity.getProposal());
        assertEquals(0.0, actualAccountEntity.getBalance());
        assertEquals(0, actualAccountEntity.getAgencyNumber());
        assertEquals(0, actualAccountEntity.getAccountNumber());
        assertEquals(0, actualAccountEntity.getBankNumber());
        assertNull(actualAccountEntity.getId());
        assertEquals("AccountEntity(id=null, bankNumber=0, agencyNumber=0, accountNumber=0, balance=0.0, proposal=null)",
                actualAccountEntity.toString());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new AccountEntity()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(UUID.randomUUID());
        accountEntity.setAccountNumber(3);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        accountEntity.setProposal(preRegistrationEntity);
        accountEntity.setBankNumber(10);
        accountEntity.setBalance(10.0);
        accountEntity.setAgencyNumber(10);

        // Act and Assert
        assertFalse((new AccountEntity()).equals(accountEntity));
    }

    @Test
    public void testEquals3() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(null);
        accountEntity.setAccountNumber(3);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        accountEntity.setProposal(preRegistrationEntity);
        accountEntity.setBankNumber(10);
        accountEntity.setBalance(10.0);
        accountEntity.setAgencyNumber(10);

        // Act and Assert
        assertFalse((new AccountEntity()).equals(accountEntity));
    }

    @Test
    public void testEquals4() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(null);
        accountEntity.setAccountNumber(3);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        accountEntity.setProposal(preRegistrationEntity);
        accountEntity.setBankNumber(0);
        accountEntity.setBalance(10.0);
        accountEntity.setAgencyNumber(10);

        // Act and Assert
        assertFalse((new AccountEntity()).equals(accountEntity));
    }

    @Test
    public void testEquals5() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(null);
        accountEntity.setAccountNumber(3);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        accountEntity.setProposal(preRegistrationEntity);
        accountEntity.setBankNumber(0);
        accountEntity.setBalance(10.0);
        accountEntity.setAgencyNumber(0);

        // Act and Assert
        assertFalse((new AccountEntity()).equals(accountEntity));
    }

    @Test
    public void testGetAccountNumber() {
        // Arrange, Act and Assert
        assertEquals(0, (new AccountEntity()).getAccountNumber());
    }

    @Test
    public void testGetAgencyNumber() {
        // Arrange, Act and Assert
        assertEquals(0, (new AccountEntity()).getAgencyNumber());
    }

    @Test
    public void testGetBalance() {
        // Arrange, Act and Assert
        assertEquals(0.0, (new AccountEntity()).getBalance());
    }

    @Test
    public void testGetBankNumber() {
        // Arrange, Act and Assert
        assertEquals(0, (new AccountEntity()).getBankNumber());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new AccountEntity()).getId());
    }

    @Test
    public void testGetProposal() {
        // Arrange, Act and Assert
        assertNull((new AccountEntity()).getProposal());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(-92165491, (new AccountEntity()).hashCode());
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
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setProposal(preRegistrationEntity);

        // Act and Assert
        assertEquals(-1734877740, accountEntity.hashCode());
    }

    @Test
    public void testSetAccountNumber() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();

        // Act
        accountEntity.setAccountNumber(3);

        // Assert
        assertEquals(3, accountEntity.getAccountNumber());
    }

    @Test
    public void testSetAgencyNumber() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();

        // Act
        accountEntity.setAgencyNumber(10);

        // Assert
        assertEquals(10, accountEntity.getAgencyNumber());
    }

    @Test
    public void testSetBalance() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();

        // Act
        accountEntity.setBalance(10.0);

        // Assert
        assertEquals(10.0, accountEntity.getBalance());
    }

    @Test
    public void testSetBankNumber() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();

        // Act
        accountEntity.setBankNumber(10);

        // Assert
        assertEquals(10, accountEntity.getBankNumber());
    }

    @Test
    public void testSetId() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        accountEntity.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, accountEntity.getId());
    }

    @Test
    public void testSetProposal() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();

        // Act
        accountEntity.setProposal(new PreRegistrationEntity());

        // Assert
        assertEquals("AccountEntity(id=null, bankNumber=0, agencyNumber=0, accountNumber=0, balance=0.0, proposal"
                + "=PreRegistrationEntity(id=null, firstName=null, lastName=null, email=null, birthDate=null, cpf=null,"
                + " status=null))", accountEntity.toString());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("AccountEntity(id=null, bankNumber=0, agencyNumber=0, accountNumber=0, balance=0.0, proposal=null)",
                (new AccountEntity()).toString());
    }
}

