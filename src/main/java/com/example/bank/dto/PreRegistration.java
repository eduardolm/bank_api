package com.example.bank.dto;

import com.example.bank.enums.Status;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class PreRegistration {

    private UUID id;
    @NotBlank(message = "{firstName.notblank}")
    private String firstName;
    @NotBlank(message = "{lastName.notblank}")
    private String lastName;
    @Email(message = "{email.invalid}")
    @NotBlank(message = "{email.notblank}")
    private String email;
    @NotNull(message = "{birthDate.notnull}")
    @Past(message = "{birthDate.past}")
    private LocalDate birthDate;
    @CPF(message = "CPF inválido.")
    @NotBlank(message = "{cpf.notblank}")
    private String cpf;
    private Status status = Status.UNDER_PRE_ANALYSIS;


}