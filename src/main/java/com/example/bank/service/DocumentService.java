package com.example.bank.service;

import com.example.bank.controller.request.PreRegistrationEditRequest;
import com.example.bank.dto.Document;
import com.example.bank.dto.PreRegistration;
import com.example.bank.entity.DocumentEntity;
import com.example.bank.entity.PreRegistrationEntity;
import com.example.bank.entity.ProposalEntity;
import com.example.bank.enums.Status;
import com.example.bank.helper.BucketHelper;
import com.example.bank.helper.FileConversion;
import com.example.bank.repository.DocumentRepository;
import com.example.bank.repository.PreRegistrationRepository;
import com.example.bank.repository.ProposalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentService extends BucketHelper{

    BucketHelper bucketHelper = new BucketHelper();
    private final CreateBucketRequest createBucketRequest = bucketHelper.connectS3();
    private ObjectMapper objectMapper;
    private DocumentRepository documentRepository;
    private ProposalRepository proposalRepository;
    private PreRegistrationRepository preRegistrationRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentService.class);
    @Value("${file.path}")
    private String filePath;

    public DocumentService(ObjectMapper objectMapper,
                           DocumentRepository documentRepository,
                           ProposalRepository proposalRepository,
                           PreRegistrationRepository preRegistrationRepository
    ) {
        this.objectMapper = objectMapper;
        this.documentRepository = documentRepository;
        this.proposalRepository = proposalRepository;
        this.preRegistrationRepository = preRegistrationRepository;
    }

    public void createDocument(PreRegistration preRegistration, MultipartFile multipartFile) throws IOException {

        FileConversion fileConversion = new FileConversion();
        Document document = new Document();
        PreRegistrationEditRequest preRegistrationEditRequest = objectMapper.convertValue(
                preRegistration,
                PreRegistrationEditRequest.class);
        preRegistrationEditRequest.setStatus(Status.UNDER_ANALYSIS_DOCUMENTS);
        PreRegistrationEntity preRegistrationEntity = objectMapper.convertValue(
                preRegistrationEditRequest, PreRegistrationEntity.class);

        preRegistrationRepository.save(preRegistrationEntity);

        File file = fileConversion.convertMultiPartToFile(multipartFile);

        document.setId(preRegistrationEditRequest.getId());
        String imageAddress = this.uploadFileToS3Bucket(
                this.createBucket(),
                file,
                this.filePath,
                preRegistrationEditRequest.getId().toString());

        document.setImageAddress(imageAddress);
        DocumentEntity documentEntity = objectMapper.convertValue(document, DocumentEntity.class);
        documentRepository.save(documentEntity);

        ProposalEntity proposalEntity = proposalRepository.findById(preRegistrationEditRequest.getId()).orElseThrow();
        proposalEntity.setDocument(documentEntity);
        proposalRepository.save(proposalEntity);

    }

    public List<DocumentEntity> getDocuments() {

        return documentRepository.findAll();
    }

    public Document getDocument(UUID id) {
        return objectMapper.convertValue(documentRepository.findById(id).orElseThrow(), Document.class);
    }

    public String createBucket(){

        List<String> bucketList = new ArrayList<>();
        this.bucketHelper.listBucketStream().buckets().stream().forEach(x -> bucketList.add(x.name()));
        if (this.bucketHelper.listBucketStream().buckets().stream().findAny().isEmpty()){
            return this.bucketHelper.createBucket(this.createBucketRequest);
        }
        return bucketList.get(0);
    }

    public String uploadFileToS3Bucket(String bucketName, File file, String filePath,
                                       String proposalId) throws FileNotFoundException {

        final String uniqueFileName = LocalDateTime.now() + "_" + file.getName();
        LOGGER.info("Uploading file with name= " + uniqueFileName);
        var key = "_" + proposalId + ".jpg";
        PutObjectResponse response = this.bucketHelper.getS3().putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .build(),
                RequestBody.fromBytes(getObjectFile(filePath)));
        return bucketName + key;
    }

    public byte[] getObjectFile(String path) throws FileNotFoundException {

        return readBytesFromFile(path);
    }

    private byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {
            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytesArray;
    }
}
