package com.example.bank.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Token {

    private UUID id;
    private String token;
    private LocalDateTime expires;
    private String used;
}
