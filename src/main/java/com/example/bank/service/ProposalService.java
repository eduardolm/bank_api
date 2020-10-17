package com.example.bank.service;

import com.example.bank.dto.Proposal;
import com.example.bank.entity.ProposalEntity;
import com.example.bank.enums.Status;
import com.example.bank.repository.PreRegistrationRepository;
import com.example.bank.repository.ProposalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProposalService {

    private ProposalRepository proposalRepository;
    private ObjectMapper objectMapper;
    private PreRegistrationRepository preRegistrationRepository;

    public ProposalService(
            ProposalRepository proposalRepository,
            ObjectMapper objectMapper,
            PreRegistrationRepository preRegistrationRepository) {

        this.proposalRepository = proposalRepository;
        this.objectMapper = objectMapper;
        this.preRegistrationRepository = preRegistrationRepository;
    }

    public void createProposal(Proposal proposal) {

        ProposalEntity proposalEntity = objectMapper.convertValue(proposal, ProposalEntity.class);
        var preRegistrationEntity = preRegistrationRepository.findById(proposal.getId()).orElseThrow();
        preRegistrationEntity.setStatus(Status.UNDER_ANALYSIS_DATA);
        proposalEntity.setProposal(preRegistrationEntity);
        proposalRepository.save(proposalEntity);
    }

    public List<ProposalEntity> getProposals() {

        return proposalRepository.findAll();
    }

    public Proposal getProposal(UUID id) {

        return objectMapper.convertValue(proposalRepository.findById(id).orElseThrow(), Proposal.class);
    }
}
