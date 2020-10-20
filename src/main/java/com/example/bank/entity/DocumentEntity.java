package com.example.bank.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name = "files")
public class DocumentEntity implements Serializable {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column
    private String imageAddress;
}
