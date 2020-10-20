package com.example.bank.entity;

import com.example.bank.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "pre_registration")
public class PreRegistrationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

}
