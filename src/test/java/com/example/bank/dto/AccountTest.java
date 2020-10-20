package com.example.bank.dto;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new Account()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        Account actualAccount = new Account();

        // Assert
        assertEquals("Account(id=null, bankNumber=0, agencyNumber=0, accountNumber=0, balance=0.0)",
                actualAccount.toString());
        assertEquals(0.0, actualAccount.getBalance());
        assertEquals(0, actualAccount.getAgencyNumber());
        assertEquals(0, actualAccount.getAccountNumber());
        assertEquals(0, actualAccount.getBankNumber());
        assertNull(actualAccount.getId());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new Account()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        Account account = new Account();

        // Act and Assert
        assertTrue(account.equals(new Account()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        Account account = new Account();
        account.setAccountNumber(3);

        // Act and Assert
        assertFalse(account.equals(new Account()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        Account account = new Account();
        account.setBankNumber(10);

        // Act and Assert
        assertFalse(account.equals(new Account()));
    }

    @Test
    public void testEquals5() {
        // Arrange
        Account account = new Account();
        account.setBalance(10.0);

        // Act and Assert
        assertFalse(account.equals(new Account()));
    }

    @Test
    public void testEquals6() {
        // Arrange
        Account account = new Account();
        account.setAgencyNumber(10);

        // Act and Assert
        assertFalse(account.equals(new Account()));
    }

    @Test
    public void testEquals7() {
        // Arrange
        Account account = new Account();
        account.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse(account.equals(new Account()));
    }

    @Test
    public void testEquals8() {
        // Arrange
        Account account = new Account();
        account.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse((new Account()).equals(account));
    }

    @Test
    public void testGetAccountNumber() {
        // Arrange, Act and Assert
        assertEquals(0, (new Account()).getAccountNumber());
    }

    @Test
    public void testGetAgencyNumber() {
        // Arrange, Act and Assert
        assertEquals(0, (new Account()).getAgencyNumber());
    }

    @Test
    public void testGetBalance() {
        // Arrange, Act and Assert
        assertEquals(0.0, (new Account()).getBalance());
    }

    @Test
    public void testGetBankNumber() {
        // Arrange, Act and Assert
        assertEquals(0, (new Account()).getBankNumber());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new Account()).getId());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(1235970822, (new Account()).hashCode());
    }

    @Test
    public void testSetAccountNumber() {
        // Arrange
        Account account = new Account();

        // Act
        account.setAccountNumber(3);

        // Assert
        assertEquals(3, account.getAccountNumber());
    }

    @Test
    public void testSetAgencyNumber() {
        // Arrange
        Account account = new Account();

        // Act
        account.setAgencyNumber(10);

        // Assert
        assertEquals(10, account.getAgencyNumber());
    }

    @Test
    public void testSetBalance() {
        // Arrange
        Account account = new Account();

        // Act
        account.setBalance(10.0);

        // Assert
        assertEquals(10.0, account.getBalance());
    }

    @Test
    public void testSetBankNumber() {
        // Arrange
        Account account = new Account();

        // Act
        account.setBankNumber(10);

        // Assert
        assertEquals(10, account.getBankNumber());
    }

    @Test
    public void testSetId() {
        // Arrange
        Account account = new Account();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        account.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, account.getId());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("Account(id=null, bankNumber=0, agencyNumber=0, accountNumber=0, balance=0.0)",
                (new Account()).toString());
    }
}

