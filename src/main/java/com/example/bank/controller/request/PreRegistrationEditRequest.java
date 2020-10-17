package com.example.bank.controller.request;


import com.example.bank.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PreRegistrationEditRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String cpf;
    private Status status;
}
