package com.example.bank.repository;

import com.example.bank.entity.ProposalReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProposalReviewRepository extends JpaRepository<ProposalReviewEntity, UUID> {
}
