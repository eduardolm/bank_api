package com.example.bank.service;

import com.example.bank.entity.TokenEntity;
import com.example.bank.enums.Used;
import com.example.bank.helper.TokenHelper;
import com.example.bank.repository.PreRegistrationRepository;
import com.example.bank.repository.TokenRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TokenService {

    private PreRegistrationRepository preRegistrationRepository;
    private EmailService emailService;
    private TokenRepository tokenRepository;
    @Value("${email.to}")
    private String emailRecipient;

    public TokenService(PreRegistrationRepository preRegistrationRepository,
                        EmailService emailService,
                        TokenRepository tokenRepository) {

        this.preRegistrationRepository = preRegistrationRepository;
        this.emailService = emailService;
        this.tokenRepository = tokenRepository;
    }

    public JSONObject createToken(String email, String cpf) {

        JSONObject response = new JSONObject();
        TokenHelper token = new TokenHelper();
        var preRegistrationEntityList = preRegistrationRepository.findAll();

        for (var item : preRegistrationEntityList) {

            if (item.getCpf().equals(cpf) && item.getEmail().equals(email)) {

                var userToken = token.generateRandomToken(6, true, true);
                TokenEntity tokenEntity = new TokenEntity();
                tokenEntity.setId(item.getId());
                tokenEntity.setToken(userToken.get("Token").toString());
                tokenEntity.setExpires((LocalDateTime) userToken.get("Expires"));
                tokenEntity.setUsed(Used.NO);
                tokenEntity.setProposal(item);
                tokenRepository.save(tokenEntity);

                emailService.sendSimpleMessage(this.emailRecipient, "Procedimento de Segurança - Banco X",
                        "Este e-mail foi gerado automaticamente por nossos servidores, quando tentou " +
                                "acessar sua conta pela primeira vez." +
                                "\nVocê está recebendo seu token de acesso para criação de uma senha forte, " +
                                " de 8 dígitos." +
                                "\n\nO procedimento é bem simples: Digite o token recebido no campo token." +
                                "\nDigite uma senha forte no campo senha." +
                                "\n\nApós a finalização do processo, enviaremos um e-mail informando que sua senha " +
                                "foi alterada." +
                                "\n\nIMPORTANTE: O token tem validade de 10 minutos. Após esse prazo, é necessário " +
                                "realizar todo o procedimento novamente." +
                                "\n\nToken: " + userToken.getAsString("Token") + "" +
                                "\n\nValidade: " + userToken.getAsString("Expires"));

                response.put("Code", 200);
                response.put("Status", "OK");
                response.put("Message", "Token gerado com sucesso.");
            }
        }
        return response;
    }

    public TokenEntity getToken(UUID id) {

        return tokenRepository.findById(id).orElseThrow();
    }

}
