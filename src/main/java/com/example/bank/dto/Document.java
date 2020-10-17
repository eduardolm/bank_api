package com.example.bank.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Document {

    private UUID id;
    private Byte[] image;

}
