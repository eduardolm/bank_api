package com.example.bank.entity;

import com.example.bank.enums.Used;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "token")
public class TokenEntity {

    @Id
    @Column(name = "id")
    private UUID id;
    private String token;
    private LocalDateTime expires;
    @Enumerated(EnumType.STRING)
    private Used used;

    @OneToOne
    @MapsId
    private PreRegistrationEntity proposal;
}
