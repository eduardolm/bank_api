package com.example.bank.service;

import com.example.bank.dto.Document;
import com.example.bank.dto.PreRegistration;
import com.example.bank.dto.Proposal;
import com.example.bank.dto.ProposalReview;
import com.example.bank.entity.ProposalReviewEntity;
import com.example.bank.enums.Accepted;
import com.example.bank.enums.Status;
import com.example.bank.repository.DocumentRepository;
import com.example.bank.repository.PreRegistrationRepository;
import com.example.bank.repository.ProposalRepository;
import com.example.bank.repository.ProposalReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProposalReviewService {

    private PreRegistrationRepository preRegistrationRepository;
    private ProposalRepository proposalRepository;
    private DocumentRepository documentRepository;
    private ProposalReviewRepository proposalReviewRepository;
    private ObjectMapper objectMapper;

    public ProposalReviewService(PreRegistrationRepository preRegistrationRepository,
                                 ProposalRepository proposalRepository,
                                 DocumentRepository documentRepository,
                                 ProposalReviewRepository proposalReviewRepository,
                                 ObjectMapper objectMapper){

        this.preRegistrationRepository = preRegistrationRepository;
        this.proposalRepository = proposalRepository;
        this.documentRepository = documentRepository;
        this.proposalReviewRepository = proposalReviewRepository;
        this.objectMapper = objectMapper;
    }

    public JSONObject createProposalReview(ProposalReview proposalReview) {

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
            // TODO: Enviar e-mail implorando
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
            // TODO: Enviar e-mail informando que conta será aberta
            // TODO: Enviar proposal para aprovação do parceiro

            response.put("Code", 200);
            response.put("Status", "Created");
            response.put("Mensagem", "Obrigado por escolher o nosso banco! Sua conta será criada.");
        }
        proposalReviewRepository.save(proposalReviewEntity);
        return response;
    }

    public ProposalReview getProposalReview(UUID id) {
        ProposalReview proposalReview = new ProposalReview();
        PreRegistration preRegistration = objectMapper.convertValue(preRegistrationRepository.findById(id).orElseThrow(),
                PreRegistration.class);

        Proposal proposal = objectMapper.convertValue(proposalRepository.findById(id).orElseThrow(), Proposal.class);
        objectMapper.convertValue(documentRepository.findById(id).orElseThrow(), Document.class);

        proposalReview.setId(preRegistration.getId());
        proposalReview.setFirstName(preRegistration.getFirstName());
        proposalReview.setLastName(preRegistration.getLastName());
        proposalReview.setEmail(preRegistration.getEmail());
        proposalReview.setBirtDate(preRegistration.getBirthDate());
        proposalReview.setCpf(preRegistration.getCpf());
        proposalReview.setZip(proposal.getZip());
        proposalReview.setStreet(proposal.getStreet());
        proposalReview.setComplement(proposal.getComplement());
        proposalReview.setNeighborhood(proposal.getNeighborhood());
        proposalReview.setCity(proposal.getCity());
        proposalReview.setState(proposal.getState());
        proposalReview.setStatus(Status.WAITING_FOR_APPROVAL.toString());
        proposalReview.setAccepted(Accepted.NO.toString());

        return proposalReview;
    }
}
