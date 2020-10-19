package com.example.bank.service;

import com.example.bank.dto.Document;
import com.example.bank.dto.PreRegistration;
import com.example.bank.dto.ProposalReview;
import com.example.bank.entity.ProposalEntity;
import com.example.bank.entity.ProposalReviewEntity;
import com.example.bank.enums.Accepted;
import com.example.bank.enums.Status;
import com.example.bank.helper.HttpClientPost;
import com.example.bank.repository.DocumentRepository;
import com.example.bank.repository.PreRegistrationRepository;
import com.example.bank.repository.ProposalRepository;
import com.example.bank.repository.ProposalReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class ProposalReviewService {

    private PreRegistrationRepository preRegistrationRepository;
    private ProposalRepository proposalRepository;
    private DocumentRepository documentRepository;
    private ProposalReviewRepository proposalReviewRepository;
    private ObjectMapper objectMapper;
    private EmailService emailService;
    @Value("${email.to}")
    private String emailRecipient;

    public ProposalReviewService(PreRegistrationRepository preRegistrationRepository,
                                 ProposalRepository proposalRepository,
                                 DocumentRepository documentRepository,
                                 ProposalReviewRepository proposalReviewRepository,
                                 ObjectMapper objectMapper,
                                 EmailService emailService){

        this.preRegistrationRepository = preRegistrationRepository;
        this.proposalRepository = proposalRepository;
        this.documentRepository = documentRepository;
        this.proposalReviewRepository = proposalReviewRepository;
        this.objectMapper = objectMapper;
        this.emailService = emailService;
    }

    public JSONObject createProposalReview(ProposalReview proposalReview) throws IOException, InterruptedException {

        var clientPost = new HttpClientPost(objectMapper, proposalReviewRepository);
        var response = new JSONObject();
        var proposalReviewEntity = objectMapper
                .convertValue(proposalReview, ProposalReviewEntity.class);

        var preRegistrationEntity = preRegistrationRepository
                .findById(proposalReview.getId()).orElseThrow();

        var proposalEntity = proposalRepository.findById(proposalReview.getId()).orElseThrow();
        var documentEntity = documentRepository.findById(proposalReview.getId()).orElseThrow();

        proposalReviewEntity.setPreRegistrationEntity(preRegistrationEntity);
        proposalReviewEntity.setProposalEntity(proposalEntity);
        proposalReviewEntity.setDocumentEntity(documentEntity);

        if (proposalReviewEntity.getAccepted() == Accepted.NO) {

            preRegistrationEntity.setStatus(Status.CANCELLED);
            preRegistrationRepository.save(preRegistrationEntity);
            proposalReviewEntity.setStatus(Status.CANCELLED);
            proposalReviewRepository.save(proposalReviewEntity);

            emailService.sendSimpleMessage(this.emailRecipient, "Abertura de conta no banco X",
                    "Ficamos muito tristes por não estar aqui conosco... Essa é uma daquelas escolhas difíceis, " +
                            "que podem mudar sua vida para sempre. Um banco rápido, inovador, parceiro faz toda a " +
                            "diferença. Por isso que gostaríamos de pedir outra chance de fazermos " +
                            "parte de sua vida...");

            response.put("Code", 200);
            response.put("Status", "OK");
            response.put("Mensagem", "Ficamos muito tristes que não continuará com a abertura de sua conta. " +
                    "Gostaríamos muito de tê-lo aqui conosco!");

        }
        else {
            preRegistrationEntity.setStatus(Status.WAITING_FOR_PARTNER_APPROVAL);
            preRegistrationRepository.save(preRegistrationEntity);

            proposalReviewEntity.setStatus(Status.WAITING_FOR_PARTNER_APPROVAL);
            proposalReviewRepository.save(proposalReviewEntity);

            emailService.sendSimpleMessage(this.emailRecipient, "Abertura de conta no banco X",
                    "Parabéns! Sua proposta foi aprovada e em breve sua conta será criada. Fique atento à " +
                            "sua caixa de e-mails, para maiores informações. Agradecemos a preferência. S" +
                            "eja MUITO bem-vindo(a).");

            var postResponse = clientPost.sendPostRequest(proposalReviewEntity.getId());

            response.put("Code", 200);
            response.put("Status", "Created");
            response.put("Mensagem", "Obrigado por escolher o nosso banco! Sua conta será criada.");
        }
        proposalReviewRepository.save(proposalReviewEntity);
        return response;
    }

    public ProposalReview getProposalReview(UUID id) {

        var tempStatus = new ArrayList<Status>();
        tempStatus.add(Status.APPROVED);
        tempStatus.add(Status.CANCELLED);
        tempStatus.add(Status.DENIED);
        tempStatus.add(Status.RELEASED);
        tempStatus.add(Status.WAITING_FOR_PARTNER_APPROVAL);

        ProposalReviewEntity proposalReviewEntity = proposalReviewRepository.findById(id).orElseThrow();

        PreRegistration preRegistration = objectMapper.convertValue(preRegistrationRepository.findById(id).orElseThrow(),
                PreRegistration.class);

        ProposalEntity proposalEntity = proposalRepository.findById(id).orElseThrow();
        objectMapper.convertValue(documentRepository.findById(id).orElseThrow(), Document.class);

        proposalReviewEntity.setId(preRegistration.getId());
        proposalReviewEntity.setFirstName(preRegistration.getFirstName());
        proposalReviewEntity.setLastName(preRegistration.getLastName());
        proposalReviewEntity.setEmail(preRegistration.getEmail());
        proposalReviewEntity.setBirtDate(preRegistration.getBirthDate());
        proposalReviewEntity.setCpf(preRegistration.getCpf());
        proposalReviewEntity.setZip(proposalEntity.getZip());
        proposalReviewEntity.setStreet(proposalEntity.getStreet());
        proposalReviewEntity.setComplement(proposalEntity.getComplement());
        proposalReviewEntity.setNeighborhood(proposalEntity.getNeighborhood());
        proposalReviewEntity.setCity(proposalEntity.getCity());
        proposalReviewEntity.setState(proposalEntity.getState());

        if (!tempStatus.contains(proposalReviewEntity.getStatus())) {
            proposalReviewEntity.setStatus(Status.WAITING_FOR_APPROVAL);
        }
        if (!proposalReviewEntity.getAccepted().equals(Accepted.YES)) {
            proposalReviewEntity.setAccepted(Accepted.NO);
        }
        return objectMapper.convertValue(proposalReviewEntity, ProposalReview.class);
    }
}
