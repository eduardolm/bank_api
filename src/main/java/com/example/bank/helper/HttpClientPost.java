package com.example.bank.helper;

import com.example.bank.dto.ProposalReview;
import com.example.bank.repository.ProposalReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;

public class HttpClientPost {

    private ObjectMapper objectMapper;
    private ProposalReviewRepository proposalReviewRepository;

    public HttpClientPost(ObjectMapper objectMapper, ProposalReviewRepository proposalReviewRepository) {
        this.objectMapper = objectMapper;
        this.proposalReviewRepository = proposalReviewRepository;
    }

    public HttpResponse<String> sendPostRequest(UUID id) throws IOException, InterruptedException {

        String requestBody = objectMapper.writeValueAsString(objectMapper
                .convertValue(proposalReviewRepository.findById(id).orElseThrow(), ProposalReview.class));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://httpbin.org/post"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }
}
