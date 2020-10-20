package com.example.bank.validator;

import com.example.bank.dto.Transfer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomValidatorsTest {
    @Test
    public void testValidateAge() {
        // Arrange, Act and Assert
        assertTrue(CustomValidators.validateAge(LocalDate.ofEpochDay(1L)));
    }

    @Test
    public void testValidateTransfer() {
        // Arrange, Act and Assert
        assertFalse(CustomValidators.validateTransfer(new Transfer()));
    }

    @Test
    public void testValidateTransfer2() {
        // Arrange
        Transfer transfer = new Transfer();
        transfer.setTransferDoc(null);

        // Act and Assert
        assertFalse(CustomValidators.validateTransfer(transfer));
    }

    @Test
    public void testValidateTransfer3() {
        // Arrange
        Transfer transfer = new Transfer();
        transfer.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse(CustomValidators.validateTransfer(transfer));
    }

    @Test
    public void testValidateTransfer4() {
        // Arrange
        Transfer transfer = new Transfer();
        transfer.setTransferAmount(10.0);
        transfer.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse(CustomValidators.validateTransfer(transfer));
    }
}

