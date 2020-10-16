package com.example.bank.service;

import com.example.bank.controller.request.ProposalEditRequest;
import com.example.bank.dto.Proposal;
import com.example.bank.entity.ProposalEntity;
import com.example.bank.enums.Status;
import com.example.bank.helper.BucketHelper;
import com.example.bank.repository.ProposalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@Service
public class ProposalService {
    private ProposalRepository proposalRepository;
    private ObjectMapper objectMapper;

    public ProposalService(ProposalRepository proposalRepository, ObjectMapper objectMapper) {
        this.proposalRepository = proposalRepository;
        this.objectMapper = objectMapper;
    }

    public void createProposal(Proposal proposal) throws URISyntaxException {
        ProposalEntity proposalEntity = objectMapper.convertValue(proposal, ProposalEntity.class);
        BucketHelper s3 = new BucketHelper();
        s3.connectS3();
        proposalRepository.save(proposalEntity);
    }

    public List<ProposalEntity> getProposals() {
        List<ProposalEntity> all = proposalRepository.findAll();
        return all;
    }

    public ProposalEntity getProposal(UUID id) {
        ProposalEntity proposal = proposalRepository.findById(id).orElseThrow();
        return proposal;
    }

    public void updateProposal(UUID id, ProposalEditRequest proposalEditRequest, Status status) {
        ProposalEntity proposalEntity = objectMapper.convertValue(proposalEditRequest, ProposalEntity.class);
        proposalEntity.setId(id);
        proposalEntity.setStatus(status);
        proposalRepository.save(proposalEntity);
    }
}
