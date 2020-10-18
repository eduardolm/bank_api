package com.example.bank.service;

import com.example.bank.controller.request.PreRegistrationEditRequest;
import com.example.bank.dto.PreRegistration;
import com.example.bank.entity.PreRegistrationEntity;
import com.example.bank.enums.Status;
import com.example.bank.repository.PreRegistrationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class PreRegistrationService {

    private PreRegistrationRepository preRegistrationRepository;
    private ObjectMapper objectMapper;

    public PreRegistrationService(PreRegistrationRepository preRegistrationRepository,
                                  ObjectMapper objectMapper) {

        this.preRegistrationRepository = preRegistrationRepository;
        this.objectMapper = objectMapper;
    }

    public void createPreRegistration(PreRegistration preRegistration) throws FileNotFoundException {

        PreRegistrationEntity preRegistrationEntity = objectMapper.convertValue(
                preRegistration,
                PreRegistrationEntity.class
        );

        preRegistrationRepository.save(preRegistrationEntity);
    }

    public List<PreRegistrationEntity> getPreRegistrations() {

        return preRegistrationRepository.findAll();
    }

    public PreRegistrationEntity getPreRegistration(UUID id) {

        return preRegistrationRepository.findById(id).orElseThrow();
    }

    public void updatePreRegistration(UUID id, PreRegistrationEditRequest preRegistrationEditRequest, Status status) {

        PreRegistrationEntity preRegistrationEntity = objectMapper.convertValue(
                preRegistrationEditRequest,
                PreRegistrationEntity.class
        );

        preRegistrationEntity.setId(id);
        preRegistrationEntity.setStatus(status);
        preRegistrationRepository.save(preRegistrationEntity);
    }
}
