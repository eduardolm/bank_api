package com.example.bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name = "account")
public class AccountEntity implements Serializable {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(nullable = false)
    private int bankNumber;
    @Column(nullable = false)
    private int agencyNumber;
    @Column(nullable = false)
    private int accountNumber;
    @Column
    private double balance;

    @OneToOne
    @MapsId
    private PreRegistrationEntity proposal;
}
