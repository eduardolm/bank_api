package com.example.bank.service;

import com.example.bank.dto.Token;
import com.example.bank.entity.PasswordEntity;
import com.example.bank.entity.TokenEntity;
import com.example.bank.enums.Used;
import com.example.bank.helper.TokenHelper;
import com.example.bank.repository.PasswordRepository;
import com.example.bank.repository.PreRegistrationRepository;
import com.example.bank.repository.TokenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PasswordService {

    private PreRegistrationRepository preRegistrationRepository;
    private PasswordRepository passwordRepository;
    private ObjectMapper objectMapper;
    private TokenRepository tokenRepository;
    private EmailService emailService;
    @Value("${email.to}")
    private String emailRecipient;

    public PasswordService(PreRegistrationRepository preRegistrationRepository,
                           PasswordRepository passwordRepository,
                           ObjectMapper objectMapper,
                           TokenRepository tokenRepository,
                           EmailService emailService) {

        this.preRegistrationRepository = preRegistrationRepository;
        this.passwordRepository = passwordRepository;
        this.objectMapper = objectMapper;
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
    }

    public JSONObject createPassword(Token token) {

        JSONObject response = new JSONObject();
        var tokenEntity = objectMapper.convertValue(token, TokenEntity.class);
        var preRegistrationEntity = preRegistrationRepository.findById(token.getId()).orElseThrow();
        var passwordEntity = new PasswordEntity();

        if (tokenEntity.getUsed().equals(Used.YES)) {

            response.put("Code",400);
            response.put("Status", "Bad Request");
            response.put("Message", "O token já foi utilizado. Favor entrar em contato com sua agência e solicitar" +
                    "a criação de uma nova senha.");
        }
        else if (LocalDateTime.now().isAfter(tokenEntity.getExpires())) {

            response.put("Code",400);
            response.put("Status", "Bad Request");
            response.put("Message", "O token Está expirado. Refazer o processo para cadastrar sua nova senha.");
        }
        else {

            TokenHelper tokenHelper = new TokenHelper();
            passwordEntity.setId(preRegistrationEntity.getId());
            passwordEntity.setPassword(tokenHelper.generateStrongPassword());
            passwordEntity.setProposal(preRegistrationEntity);
            passwordRepository.save(passwordEntity);

            tokenEntity.setUsed(Used.YES);
            tokenEntity.setProposal(preRegistrationEntity);
            tokenRepository.save(tokenEntity);

            emailService.sendSimpleMessage(this.emailRecipient, "Senha alterada - Banco X",
                    "Este e-mail foi gerado automaticamente por nossos sistemas quando solicitou a criação de " +
                            "sua senha. " +
                            "\nSua senha foi gerada com sucesso! " +
                            "\nSeguem dados para acesso: " +
                            "\n\nSenha temporária: " + passwordEntity.getPassword() + "" +
                            "\n\nUtilize a senha recebida para efetuar seu primeiro acesso. O sistema irá solicitar " +
                            "a alteração da sua senha temporária durante o primeiro acesso à sua conta. " +
                            "\n\n Seja muito bem-vindo(a)!");

            response.put("Code",200);
            response.put("Status", "Ok");
            response.put("Message", "Senha gerada com sucesso.");

        }
        return response;
    }
}
