package com.example.bank.repository;

import com.example.bank.entity.ProposalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProposalRepository extends JpaRepository<ProposalEntity, UUID> {
}
