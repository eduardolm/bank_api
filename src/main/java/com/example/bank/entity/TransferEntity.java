package com.example.bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "transaction")
public class TransferEntity {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(nullable = false)
    private double transferAmount;
    @Column(nullable = false)
    private LocalDate transferDate;
    @Column(nullable = false)
    private UUID transferDoc;
    @Column(nullable = false)
    private int fromBank;
    @Column(nullable = false)
    private int fromAccount;
    @Column(nullable = false)
    private int fromAgency;
    @Column(nullable = false)
    private UUID fromBankDoc;
    @Column(nullable = false)
    private int toAgency;
    @Column(nullable = false)
    private int toAccount;

    @OneToOne
    @MapsId
    private AccountEntity account;
}
