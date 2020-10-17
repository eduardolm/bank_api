package com.example.bank.service;

import com.example.bank.helper.BucketHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
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

@Service
public class DocumentService extends BucketHelper{

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentService.class);

    BucketHelper bucketHelper = new BucketHelper();
    private final CreateBucketRequest createBucketRequest = bucketHelper.connectS3();

    public String createBucket(){

        List<String> bucketList = new ArrayList<String>();
        this.bucketHelper.listBucketStream().buckets().stream().forEach(x -> bucketList.add(x.name()));
        if (this.bucketHelper.listBucketStream().buckets().stream().findAny().isEmpty()){
            return this.bucketHelper.createBucket(this.createBucketRequest);
        }
        return bucketList.get(0);
    }

    public void uploadFileToS3Bucket(final String bucketName, final File file) throws FileNotFoundException {

        final String uniqueFileName = LocalDateTime.now() + "_" + file.getName();
        LOGGER.info("Uploading file with name= " + uniqueFileName);
        // Setup
        String objectPath = "E:/repo/bank/src/main/resources/static/CPF.jpg";
        PutObjectResponse response = this.bucketHelper.getS3().putObject(PutObjectRequest.builder()
        .bucket(bucketName)
        .key("key")
        .build(),
                RequestBody.fromBytes(getObjectFile(objectPath)));
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
