package com.example.bank.helper;

import lombok.Data;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.net.URI;
import java.net.URISyntaxException;

@Data
public class BucketHelper {
    Region region = Region.US_EAST_1;
    URI endpointOverride;

    {
        try {
            endpointOverride = new URI("http://localhost:4566");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    S3Client s3 = S3Client.builder()
            .endpointOverride(endpointOverride)
            .region(region)
            .build();


    public void connectS3() {
        String bucket = "bank-bucket" + System.currentTimeMillis();
        CreateBucketRequest createBucketRequest = CreateBucketRequest
                .builder()
                .bucket(bucket)
                .createBucketConfiguration(CreateBucketConfiguration.builder()
                        .locationConstraint(region.id())
                        .build())
                .build();
        this.s3.createBucket(createBucketRequest);
        ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
        ListBucketsResponse listBucketsResponse = this.s3.listBuckets((listBucketsRequest));
        listBucketsResponse.buckets().stream().forEach(x -> System.out.println(x.name()));

        DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder().bucket(bucket).build();
//        this.s3.deleteBucket(deleteBucketRequest);
    }
}
