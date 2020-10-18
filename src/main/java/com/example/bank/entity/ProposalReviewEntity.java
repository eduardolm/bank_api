package com.example.bank.entity;

import com.example.bank.enums.Accepted;
import com.example.bank.enums.State;
import com.example.bank.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "final_proposal")
public class ProposalReviewEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDate birtDate;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String zip;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String complement;
    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Accepted accepted;

    @OneToOne
    @MapsId
    private PreRegistrationEntity preRegistrationEntity;

    @OneToOne
    private ProposalEntity proposalEntity;

    @OneToOne
    private DocumentEntity documentEntity;
}
