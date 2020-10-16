package com.example.bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "files")
public class FileEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    @Lob
    private Byte[] image;

    @OneToOne
    @MapsId
    private ProposalEntity proposal;
}
