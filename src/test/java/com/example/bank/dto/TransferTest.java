package com.example.bank.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TransferTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new Transfer()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        Transfer actualTransfer = new Transfer();

        // Assert
        assertEquals(0, actualTransfer.getToAccount());
        assertNull(actualTransfer.getTransferDate());
        assertEquals(0, actualTransfer.getToAgency());
        assertNull(actualTransfer.getTransferDoc());
        assertEquals(0, actualTransfer.getFromAccount());
        assertNull(actualTransfer.getFromBankDoc());
        assertNull(actualTransfer.getId());
        assertEquals(0, actualTransfer.getFromAgency());
        assertEquals("Transfer(id=null, transferAmount=0.0, transferDate=null, transferDoc=null, fromBank=0, fromAccount=0,"
                + " fromAgency=0, fromBankDoc=null, toAgency=0, toAccount=0)", actualTransfer.toString());
        assertEquals(0, actualTransfer.getFromBank());
        assertEquals(0.0, actualTransfer.getTransferAmount());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new Transfer()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        Transfer transfer = new Transfer();

        // Act and Assert
        assertTrue(transfer.equals(new Transfer()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        Transfer transfer = new Transfer();
        transfer.setTransferAmount(10.0);

        // Act and Assert
        assertFalse(transfer.equals(new Transfer()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        Transfer transfer = new Transfer();
        transfer.setToAccount(3);

        // Act and Assert
        assertFalse(transfer.equals(new Transfer()));
    }

    @Test
    public void testEquals5() {
        // Arrange
        Transfer transfer = new Transfer();
        transfer.setFromAccount(3);

        // Act and Assert
        assertFalse(transfer.equals(new Transfer()));
    }

    @Test
    public void testEquals6() {
        // Arrange
        Transfer transfer = new Transfer();
        transfer.setTransferDoc(UUID.randomUUID());

        // Act and Assert
        assertFalse(transfer.equals(new Transfer()));
    }

    @Test
    public void testGetFromAccount() {
        // Arrange, Act and Assert
        assertEquals(0, (new Transfer()).getFromAccount());
    }

    @Test
    public void testGetFromAgency() {
        // Arrange, Act and Assert
        assertEquals(0, (new Transfer()).getFromAgency());
    }

    @Test
    public void testGetFromBank() {
        // Arrange, Act and Assert
        assertEquals(0, (new Transfer()).getFromBank());
    }

    @Test
    public void testGetFromBankDoc() {
        // Arrange, Act and Assert
        assertNull((new Transfer()).getFromBankDoc());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new Transfer()).getId());
    }

    @Test
    public void testGetToAccount() {
        // Arrange, Act and Assert
        assertEquals(0, (new Transfer()).getToAccount());
    }

    @Test
    public void testGetToAgency() {
        // Arrange, Act and Assert
        assertEquals(0, (new Transfer()).getToAgency());
    }

    @Test
    public void testGetTransferAmount() {
        // Arrange, Act and Assert
        assertEquals(0.0, (new Transfer()).getTransferAmount());
    }

    @Test
    public void testGetTransferDate() {
        // Arrange, Act and Assert
        assertNull((new Transfer()).getTransferDate());
    }

    @Test
    public void testGetTransferDoc() {
        // Arrange, Act and Assert
        assertNull((new Transfer()).getTransferDoc());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(14471337, (new Transfer()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        LocalDate transferDate = LocalDate.ofEpochDay(1L);
        Transfer transfer = new Transfer();
        transfer.setTransferDate(transferDate);

        // Act and Assert
        assertEquals(2137509854, transfer.hashCode());
    }

    @Test
    public void testSetFromAccount() {
        // Arrange
        Transfer transfer = new Transfer();

        // Act
        transfer.setFromAccount(3);

        // Assert
        assertEquals(3, transfer.getFromAccount());
    }

    @Test
    public void testSetFromAgency() {
        // Arrange
        Transfer transfer = new Transfer();

        // Act
        transfer.setFromAgency(1);

        // Assert
        assertEquals(1, transfer.getFromAgency());
    }

    @Test
    public void testSetFromBank() {
        // Arrange
        Transfer transfer = new Transfer();

        // Act
        transfer.setFromBank(1);

        // Assert
        assertEquals(1, transfer.getFromBank());
    }

    @Test
    public void testSetFromBankDoc() {
        // Arrange
        Transfer transfer = new Transfer();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        transfer.setFromBankDoc(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, transfer.getFromBankDoc());
    }

    @Test
    public void testSetId() {
        // Arrange
        Transfer transfer = new Transfer();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        transfer.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, transfer.getId());
    }

    @Test
    public void testSetToAccount() {
        // Arrange
        Transfer transfer = new Transfer();

        // Act
        transfer.setToAccount(3);

        // Assert
        assertEquals(3, transfer.getToAccount());
    }

    @Test
    public void testSetToAgency() {
        // Arrange
        Transfer transfer = new Transfer();

        // Act
        transfer.setToAgency(1);

        // Assert
        assertEquals(1, transfer.getToAgency());
    }

    @Test
    public void testSetTransferAmount() {
        // Arrange
        Transfer transfer = new Transfer();

        // Act
        transfer.setTransferAmount(10.0);

        // Assert
        assertEquals(10.0, transfer.getTransferAmount());
    }

    @Test
    public void testSetTransferDate() {
        // Arrange
        LocalDate transferDate = LocalDate.ofEpochDay(1L);
        Transfer transfer = new Transfer();

        // Act
        transfer.setTransferDate(transferDate);

        // Assert
        assertEquals(
                "Transfer(id=null, transferAmount=0.0, transferDate=1970-01-02, transferDoc=null, fromBank=0, fromAccount=0,"
                        + " fromAgency=0, fromBankDoc=null, toAgency=0, toAccount=0)",
                transfer.toString());
    }

    @Test
    public void testSetTransferDoc() {
        // Arrange
        Transfer transfer = new Transfer();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        transfer.setTransferDoc(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, transfer.getTransferDoc());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("Transfer(id=null, transferAmount=0.0, transferDate=null, transferDoc=null, fromBank=0, fromAccount=0,"
                + " fromAgency=0, fromBankDoc=null, toAgency=0, toAccount=0)", (new Transfer()).toString());
    }
}

