package com.example.bank.controller;

import com.example.bank.dto.Transfer;
import com.example.bank.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/transfer")
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {

        this.transferService = transferService;
    }

    @PostMapping
    @Async
    public ResponseEntity createTransfer(@RequestBody Transfer transfer) {

        var response = transferService.createTransfer(transfer);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity getTransfers() {

        var response =  transferService.getTransfers();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
