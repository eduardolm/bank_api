package com.example.bank.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class Account {

    private UUID id;
    @NotBlank
    @NotNull
    @NotEmpty
    private int bankNumber;
    @NotBlank
    @NotNull
    @NotEmpty
    private int agencyNumber;
    @NotBlank
    @NotNull
    @NotEmpty
    private int accountNumber;
    private double balance;
}
