package com.example.bank.dto;

import com.example.bank.config.CEP;
import com.example.bank.enums.State;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class Address {
    private UUID id;
    @NotBlank
    @CEP(message = "CEP inválido.")
    private String zip;
    @NotBlank
    private String street;
    @NotBlank
    private String neighborhood;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    private State state;
}
