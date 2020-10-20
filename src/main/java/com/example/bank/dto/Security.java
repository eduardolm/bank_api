package com.example.bank.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class Security {

    private UUID id;
    @NotBlank
    private String email;
    @NotBlank
    private String cpf;
    @NotNull
    private int token;
    @NotNull
    private int password;
}
