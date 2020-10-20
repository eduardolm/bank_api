package com.example.bank.entity;

import com.example.bank.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TransferEntityTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new TransferEntity()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        TransferEntity actualTransferEntity = new TransferEntity();

        // Assert
        assertEquals(0, actualTransferEntity.getToAccount());
        assertNull(actualTransferEntity.getTransferDate());
        assertEquals(0, actualTransferEntity.getToAgency());
        assertNull(actualTransferEntity.getTransferDoc());
        assertEquals(0, actualTransferEntity.getFromAccount());
        assertNull(actualTransferEntity.getAccount());
        assertNull(actualTransferEntity.getFromBankDoc());
        assertNull(actualTransferEntity.getId());
        assertEquals(0, actualTransferEntity.getFromAgency());
        assertEquals(
                "TransferEntity(id=null, transferAmount=0.0, transferDate=null, transferDoc=null, fromBank=0, fromAccount=0,"
                        + " fromAgency=0, fromBankDoc=null, toAgency=0, toAccount=0, account=null)",
                actualTransferEntity.toString());
        assertEquals(0, actualTransferEntity.getFromBank());
        assertEquals(0.0, actualTransferEntity.getTransferAmount());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new TransferEntity()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();
        transferEntity.setTransferDoc(UUID.randomUUID());
        transferEntity.setId(UUID.randomUUID());
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
        transferEntity.setAccount(accountEntity);
        transferEntity.setFromBank(0);
        transferEntity.setTransferAmount(10.0);
        transferEntity.setFromAgency(0);
        transferEntity.setToAgency(0);
        transferEntity.setTransferDate(LocalDate.ofEpochDay(1L));
        transferEntity.setFromBankDoc(UUID.randomUUID());
        transferEntity.setToAccount(3);
        transferEntity.setFromAccount(3);

        // Act and Assert
        assertFalse((new TransferEntity()).equals(transferEntity));
    }

    @Test
    public void testEquals3() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();
        transferEntity.setTransferDoc(UUID.randomUUID());
        transferEntity.setId(null);
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
        transferEntity.setAccount(accountEntity);
        transferEntity.setFromBank(0);
        transferEntity.setTransferAmount(10.0);
        transferEntity.setFromAgency(0);
        transferEntity.setToAgency(0);
        transferEntity.setTransferDate(LocalDate.ofEpochDay(1L));
        transferEntity.setFromBankDoc(UUID.randomUUID());
        transferEntity.setToAccount(3);
        transferEntity.setFromAccount(3);

        // Act and Assert
        assertFalse((new TransferEntity()).equals(transferEntity));
    }

    @Test
    public void testGetAccount() {
        // Arrange, Act and Assert
        assertNull((new TransferEntity()).getAccount());
    }

    @Test
    public void testGetFromAccount() {
        // Arrange, Act and Assert
        assertEquals(0, (new TransferEntity()).getFromAccount());
    }

    @Test
    public void testGetFromAgency() {
        // Arrange, Act and Assert
        assertEquals(0, (new TransferEntity()).getFromAgency());
    }

    @Test
    public void testGetFromBank() {
        // Arrange, Act and Assert
        assertEquals(0, (new TransferEntity()).getFromBank());
    }

    @Test
    public void testGetFromBankDoc() {
        // Arrange, Act and Assert
        assertNull((new TransferEntity()).getFromBankDoc());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new TransferEntity()).getId());
    }

    @Test
    public void testGetToAccount() {
        // Arrange, Act and Assert
        assertEquals(0, (new TransferEntity()).getToAccount());
    }

    @Test
    public void testGetToAgency() {
        // Arrange, Act and Assert
        assertEquals(0, (new TransferEntity()).getToAgency());
    }

    @Test
    public void testGetTransferAmount() {
        // Arrange, Act and Assert
        assertEquals(0.0, (new TransferEntity()).getTransferAmount());
    }

    @Test
    public void testGetTransferDate() {
        // Arrange, Act and Assert
        assertNull((new TransferEntity()).getTransferDate());
    }

    @Test
    public void testGetTransferDoc() {
        // Arrange, Act and Assert
        assertNull((new TransferEntity()).getTransferDoc());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(853808926, (new TransferEntity()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(null);
        accountEntity.setAccountNumber(3);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(null);
        preRegistrationEntity.setBirthDate(null);
        preRegistrationEntity.setEmail(null);
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf(null);
        preRegistrationEntity.setFirstName("Jane");
        accountEntity.setProposal(preRegistrationEntity);
        accountEntity.setBankNumber(10);
        accountEntity.setBalance(10.0);
        accountEntity.setAgencyNumber(10);
        TransferEntity transferEntity = new TransferEntity();
        transferEntity.setAccount(accountEntity);

        // Act and Assert
        assertEquals(-1692374374, transferEntity.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        LocalDate transferDate = LocalDate.ofEpochDay(1L);
        TransferEntity transferEntity = new TransferEntity();
        transferEntity.setTransferDate(transferDate);

        // Act and Assert
        assertEquals(1559029845, transferEntity.hashCode());
    }

    @Test
    public void testSetAccount() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();

        // Act
        transferEntity.setAccount(new AccountEntity());

        // Assert
        assertEquals(
                "TransferEntity(id=null, transferAmount=0.0, transferDate=null, transferDoc=null, fromBank=0, fromAccount=0,"
                        + " fromAgency=0, fromBankDoc=null, toAgency=0, toAccount=0, account=AccountEntity(id=null, bankNumber=0,"
                        + " agencyNumber=0, accountNumber=0, balance=0.0, proposal=null))",
                transferEntity.toString());
    }

    @Test
    public void testSetFromAccount() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();

        // Act
        transferEntity.setFromAccount(3);

        // Assert
        assertEquals(3, transferEntity.getFromAccount());
    }

    @Test
    public void testSetFromAgency() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();

        // Act
        transferEntity.setFromAgency(1);

        // Assert
        assertEquals(1, transferEntity.getFromAgency());
    }

    @Test
    public void testSetFromBank() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();

        // Act
        transferEntity.setFromBank(1);

        // Assert
        assertEquals(1, transferEntity.getFromBank());
    }

    @Test
    public void testSetFromBankDoc() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        transferEntity.setFromBankDoc(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, transferEntity.getFromBankDoc());
    }

    @Test
    public void testSetId() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        transferEntity.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, transferEntity.getId());
    }

    @Test
    public void testSetToAccount() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();

        // Act
        transferEntity.setToAccount(3);

        // Assert
        assertEquals(3, transferEntity.getToAccount());
    }

    @Test
    public void testSetToAgency() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();

        // Act
        transferEntity.setToAgency(1);

        // Assert
        assertEquals(1, transferEntity.getToAgency());
    }

    @Test
    public void testSetTransferAmount() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();

        // Act
        transferEntity.setTransferAmount(10.0);

        // Assert
        assertEquals(10.0, transferEntity.getTransferAmount());
    }

    @Test
    public void testSetTransferDate() {
        // Arrange
        LocalDate transferDate = LocalDate.ofEpochDay(1L);
        TransferEntity transferEntity = new TransferEntity();

        // Act
        transferEntity.setTransferDate(transferDate);

        // Assert
        assertEquals(
                "TransferEntity(id=null, transferAmount=0.0, transferDate=1970-01-02, transferDoc=null, fromBank=0,"
                        + " fromAccount=0, fromAgency=0, fromBankDoc=null, toAgency=0, toAccount=0, account=null)",
                transferEntity.toString());
    }

    @Test
    public void testSetTransferDoc() {
        // Arrange
        TransferEntity transferEntity = new TransferEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        transferEntity.setTransferDoc(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, transferEntity.getTransferDoc());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "TransferEntity(id=null, transferAmount=0.0, transferDate=null, transferDoc=null, fromBank=0, fromAccount=0,"
                        + " fromAgency=0, fromBankDoc=null, toAgency=0, toAccount=0, account=null)",
                (new TransferEntity()).toString());
    }
}

