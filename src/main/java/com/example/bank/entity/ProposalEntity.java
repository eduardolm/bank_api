package com.example.bank.entity;

import com.example.bank.enums.State;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name = "proposal")
public class ProposalEntity implements Serializable {

    @Id
    @Column(name = "id")
    private UUID id;
    private String zip;
    private String street;
    private String neighborhood;
    private String complement;
    private String city;
    @Enumerated(EnumType.STRING)
    private State state;


    @OneToOne
    @MapsId
    private PreRegistrationEntity proposal;

    @OneToOne
    private DocumentEntity document;
}
