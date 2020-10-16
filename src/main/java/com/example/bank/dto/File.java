package com.example.bank.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class File {
    private UUID id;
    private Byte[] image;

    
}
