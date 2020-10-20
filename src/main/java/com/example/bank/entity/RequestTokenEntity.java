package com.example.bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "token")
public class RequestTokenEntity {

    @Id
    @Column(name = "id")
    private UUID id;
    private String token;
    private LocalDateTime expires;

    @OneToOne
    @MapsId
    private PreRegistrationEntity proposal;
}
