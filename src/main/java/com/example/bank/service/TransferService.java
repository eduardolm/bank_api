package com.example.bank.service;

import com.example.bank.dto.Transfer;
import com.example.bank.entity.TransferEntity;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.TransferRepository;
import com.example.bank.validator.CustomValidators;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransferService {

    private TransferRepository transferRepository;
    private AccountRepository accountRepository;
    private ObjectMapper objectMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferService.class);


    public TransferService(TransferRepository transferRepository,
                           AccountRepository accountRepository,
                           ObjectMapper objectMapper) {

        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
        this.objectMapper = objectMapper;
    }

    @Async
    public JSONObject createTransfer(Transfer transfer) throws Exception {

        var response = new JSONObject();

        if (!CustomValidators.validateTransfer(transfer)) {
            response.put("Code", 400);
            response.put("Status","Bad Request");
            response.put("Message", "Erro de validação. Todos os campos são obrigatórios.");
            return response;
        }

        var transferEntity = objectMapper.convertValue(transfer, TransferEntity.class);
        var accountEntity = accountRepository.findById(transferEntity.getId()).orElseThrow();

        try {
            var transferEntityStoredList = transferRepository.findAll();

            if (!transferEntityStoredList.isEmpty()) {

                for (var item : transferEntityStoredList) {

                    if(item.getFromBankDoc().equals(transferEntity.getFromBankDoc())) {

                        LOGGER.debug("Transferência já processada: " + transferEntity.getFromBankDoc());
                        response.put("Code", 200);
                        response.put("Status","Ok");
                        response.put("Message", "Transferência já processada.");
                        return response;
                    }
                }
            }

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
