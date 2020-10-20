package com.example.bank.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class RequestToken {

    private UUID id;
    @NotBlank
    private String email;
    @NotBlank
    private String cpf;
}
