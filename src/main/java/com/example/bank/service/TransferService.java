package com.example.bank.service;

import com.example.bank.dto.Transfer;
import com.example.bank.entity.TransferEntity;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.TransferRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransferService {

    private TransferRepository transferRepository;
    private AccountRepository accountRepository;
    private ObjectMapper objectMapper;

    public TransferService(TransferRepository transferRepository,
                           AccountRepository accountRepository,
                           ObjectMapper objectMapper) {

        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
        this.objectMapper = objectMapper;
    }

    @Async
    public JSONObject createTransfer(Transfer transfer) {

        var response = new JSONObject();
        var transferEntity = objectMapper.convertValue(transfer, TransferEntity.class);
        var accountEntity = accountRepository.findById(transferEntity.getId()).orElseThrow();

        try {
            transferEntity.setAccount(accountEntity);
            transferRepository.saveAndFlush(transferEntity);

            accountEntity.setBalance(accountEntity.getBalance() + transferEntity.getTransferAmount());
            accountRepository.saveAndFlush(accountEntity);

            response.put("Code", 200);
            response.put("Status", "OK");
            response.put("Message", "Transferência processada com sucesso.");
        }
        catch (Exception ex) {
            response.put("Erro", ex.getMessage());
        }
        return response;
    }

    public TransferEntity getTransfer(UUID id) {

        return transferRepository.findById(id).orElseThrow();
    }

    public List<TransferEntity> getTransfers() {

        return transferRepository.findAll();
    }
}
