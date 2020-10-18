package com.example.bank.repository;

import com.example.bank.entity.PreRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PreRegistrationRepository extends JpaRepository<PreRegistrationEntity, UUID> {
}
