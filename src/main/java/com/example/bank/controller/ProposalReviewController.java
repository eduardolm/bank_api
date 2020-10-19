package com.example.bank.controller;

import com.example.bank.dto.ProposalReview;
import com.example.bank.service.ProposalReviewService;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("v1/review")
public class ProposalReviewController {

    private ProposalReviewService proposalReviewService;


    public ProposalReviewController(ProposalReviewService proposalReviewService) {

        this.proposalReviewService = proposalReviewService;
    }

    @PostMapping
    public ResponseEntity createProposalReview(@RequestBody ProposalReview proposalReview) throws IOException, InterruptedException {

        var response = proposalReviewService.createProposalReview(proposalReview);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProposalReview(@PathVariable() UUID id) {
        try {
            ProposalReview proposalReview = proposalReviewService.getProposalReview(id);
            return ResponseEntity.ok(proposalReview);
        }
        catch (Exception ex) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Code", 422);
            jsonObject.put("Error", "Unprocessable Entity");
            jsonObject.put("Mensagem", "As etapas anteriores precisam ser finalizadas antes do aceite da proposta.");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(jsonObject);
        }
    }
}
