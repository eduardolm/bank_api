package com.example.bank.controller;

import com.example.bank.entity.TransferEntity;
import com.example.bank.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TransferControllerTest {
    @Autowired
    private TransferService transferService;

    @Test
    public void testConstructor() {
        // Arrange and Act
        new TransferController(this.transferService);

        // Assert
        List<TransferEntity> transfers = this.transferService.getTransfers();
        assertTrue(transfers instanceof java.util.List);
        assertEquals(0, transfers.size());
    }
}

