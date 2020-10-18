package com.example.bank.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ProposalReview {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birtDate;
    private String cpf;
    private String status;
    private String zip;
    private String street;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String accepted;
}
