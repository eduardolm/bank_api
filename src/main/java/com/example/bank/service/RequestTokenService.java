package com.example.bank.service;

import com.example.bank.entity.RequestTokenEntity;
import com.example.bank.helper.TokenHelper;
import com.example.bank.repository.PreRegistrationRepository;
import com.example.bank.repository.RequestTokenRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RequestTokenService {

    private PreRegistrationRepository preRegistrationRepository;
    private EmailService emailService;
    private RequestTokenRepository requestTokenRepository;
    @Value("${email.to}")
    private String emailRecipient;

    public RequestTokenService(PreRegistrationRepository preRegistrationRepository,
                               EmailService emailService,
                               RequestTokenRepository requestTokenRepository) {

        this.preRegistrationRepository = preRegistrationRepository;
        this.emailService = emailService;
        this.requestTokenRepository = requestTokenRepository;
    }

    public JSONObject createToken(String email, String cpf) {

        JSONObject response = new JSONObject();
        TokenHelper token = new TokenHelper();
        var preRegistrationEntityList = preRegistrationRepository.findAll();

        for (var item : preRegistrationEntityList) {

            if (item.getCpf().equals(cpf) && item.getEmail().equals(email)) {

                var userToken = token.generateRandomToken(6, true, true);
                RequestTokenEntity requestTokenEntity = new RequestTokenEntity();
                requestTokenEntity.setId(item.getId());
                requestTokenEntity.setToken(userToken.get("Token").toString());
                requestTokenEntity.setExpires((LocalDateTime) userToken.get("Expires"));
                requestTokenEntity.setProposal(item);
                requestTokenRepository.save(requestTokenEntity);

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

}
