package com.example.bank.controller;

import com.example.bank.dto.Proposal;
import com.example.bank.entity.ProposalEntity;
import com.example.bank.service.ProposalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/proposal")
public class ProposalController {

    private ProposalService proposalService;
    private ObjectMapper objectMapper;

    public ProposalController(ProposalService proposalService, ObjectMapper objectMapper) {

        this.proposalService = proposalService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProposalEntity>> getProposals() {

        List<ProposalEntity> proposalEntityList = proposalService.getProposals();
        return ResponseEntity.status(HttpStatus.OK).body(proposalEntityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proposal> getProposal(@PathVariable() UUID id) {

        Proposal proposal = proposalService.getProposal(id);
        return ResponseEntity.status(HttpStatus.OK).body(proposal);
    }

    @PostMapping
    public ResponseEntity createProposal(@Valid @RequestBody Proposal proposal) {

        proposalService.createProposal(proposal);;
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
