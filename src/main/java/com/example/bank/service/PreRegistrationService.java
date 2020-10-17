package com.example.bank.service;

import com.example.bank.controller.request.PreRegistrationEditRequest;
import com.example.bank.dto.PreRegistration;
import com.example.bank.entity.PreRegistrationEntity;
import com.example.bank.enums.Status;
import com.example.bank.helper.BucketHelper;
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
    private DocumentService documentService;

    public PreRegistrationService(PreRegistrationRepository preRegistrationRepository,
                                  ObjectMapper objectMapper,
                                  DocumentService documentService) {

        this.preRegistrationRepository = preRegistrationRepository;
        this.objectMapper = objectMapper;
        this.documentService = documentService;
    }

    public void createPreRegistration(PreRegistration preRegistration) throws FileNotFoundException {

        PreRegistrationEntity preRegistrationEntity = objectMapper.convertValue(
                preRegistration,
                PreRegistrationEntity.class
        );
        BucketHelper s3 = new BucketHelper();
        documentService.downloadS3Object("bank-bucket1602877826567", "key");
        documentService.listBucketObjects(s3.getS3(), "bank-bucket1602877826567");
//        documentService.uploadFileToS3Bucket(documentService.createBucket(), new File("testando"));
        var bucketStream = s3.listBucketStream();
        bucketStream.buckets().stream().forEach(x -> System.out.println(x.name()));
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
