package com.example.bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "password")
public class PasswordEntity {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column
    private String password;

    @OneToOne
    @MapsId
    private PreRegistrationEntity proposal;
}
