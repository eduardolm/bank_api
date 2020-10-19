package com.example.bank.service;

import com.example.bank.entity.AccountEntity;
import com.example.bank.enums.Status;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.PreRegistrationRepository;
import com.example.bank.repository.ProposalReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountService {

    private PreRegistrationRepository preRegistrationRepository;
    private ProposalReviewRepository proposalReviewRepository;
    private AccountRepository accountRepository;
    private ObjectMapper objectMapper;
    private EmailService emailService;
    @Value("${bank.number}")
    private int bankNumber;
    @Value("${email.to}")
    private String emailRecipient;

    public AccountService(PreRegistrationRepository preRegistrationRepository,
                          ProposalReviewRepository proposalReviewRepository,
                          AccountRepository accountRepository,
                          ObjectMapper objectMapper,
                          EmailService emailService) {

        this.preRegistrationRepository = preRegistrationRepository;
        this.proposalReviewRepository = proposalReviewRepository;
        this.accountRepository = accountRepository;
        this.objectMapper = objectMapper;
        this.emailService = emailService;
    }

    public JSONObject createAccount(UUID id) {

        Random random = new Random();
        JSONObject response = new JSONObject();

        try {
            var proposalReviewEntity = proposalReviewRepository.findById(id).orElseThrow();
            var preRegistrationEntity = preRegistrationRepository.findById(id).orElseThrow();

            if (proposalReviewEntity.getStatus().equals(Status.APPROVED)) {

                AccountEntity accountEntity = new AccountEntity();
                accountEntity.setId(preRegistrationEntity.getId());
                accountEntity.setBankNumber(this.bankNumber);
                accountEntity.setAgencyNumber((random.nextInt(1999 - 1000 + 1) + 1000));
                accountEntity.setAccountNumber((random.nextInt(19999999 - 10000000 + 1) + 10000000));
                accountEntity.setProposal(preRegistrationEntity);
                accountEntity.setBalance(0.0);
                accountRepository.save(accountEntity);
                proposalReviewEntity.setStatus(Status.RELEASED);
                proposalReviewRepository.save(proposalReviewEntity);
                preRegistrationEntity.setStatus(Status.RELEASED);
                preRegistrationRepository.save(preRegistrationEntity);

                emailService.sendSimpleMessage(this.emailRecipient, "Sua conta foi criada!",
                        "Seja bem-vindo(a) ao banco X" +
                                "Sua conta foi criada com sucesso!" +
                                "\nSeguem os dados de sua nova conta:" +
                                "\nBanco: " + accountEntity.getBankNumber() +
                                "\nAgência: " + accountEntity.getAgencyNumber() +
                                "\nConta: " + accountEntity.getAccountNumber());

                response.put("Code", 200);
                response.put("Status", "OK");
                response.put("Message", "A conta será criada.");
            }
        }
        catch (Exception ex) {
            response.put("Message", ex.getMessage());
        }
        return response;
    }

    public List<AccountEntity> getAccounts() {

        return accountRepository.findAll();
    }

    public AccountEntity getAccount(UUID id) {

        return accountRepository.findById(id).orElseThrow();
    }

    @Async
    public CompletableFuture<JSONObject> updateBalance(UUID id, Double transferAmount) {

        JSONObject response = new JSONObject();
        try {
            var accountEntity = accountRepository.findById(id).orElseThrow();
            accountEntity.setBalance(accountEntity.getBalance() + transferAmount);
            accountRepository.saveAndFlush(accountEntity);

            response.put("Code", 200);
            response.put("Message", "Transferência realizada com sucesso.");
        }
        catch (Exception ex) {
            response.put("Code", 400);
            response.put("Error", ex.getMessage());
        }
        return CompletableFuture.completedFuture(response);
    }
}
