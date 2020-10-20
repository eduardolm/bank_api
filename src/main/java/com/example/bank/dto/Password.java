package com.example.bank.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class Password {

    private UUID id;
    @NotNull
    private String password;
}
