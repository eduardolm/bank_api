package com.example.bank.helper;

import lombok.Data;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;

@Data
public class BucketHelper {

    // Setup
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

    public CreateBucketRequest connectS3() {
        String bucket = "bank-bucket" + System.currentTimeMillis();
        return CreateBucketRequest
                .builder()
                .bucket(bucket)
                .createBucketConfiguration(CreateBucketConfiguration.builder()
                        .locationConstraint(region.id())
                        .build())
                .build();
    }

    public String createBucket(CreateBucketRequest createBucketRequest) {
        this.s3.createBucket(createBucketRequest);
        return this.listBucketStream().buckets().stream().findFirst().orElseThrow().name();
    }

    public ListBucketsResponse listBucketStream() {

        ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
        return this.s3.listBuckets(listBucketsRequest);
    }

    public void deleteAllBucketObjects(String bucket) {

        ListObjectsV2Request listObjectsV2Request = ListObjectsV2Request.builder().bucket(bucket).build();
        ListObjectsV2Response listObjectsV2Response;

        do {
            listObjectsV2Response = this.s3.listObjectsV2(listObjectsV2Request);
            for (S3Object s3Object : listObjectsV2Response.contents()) {
                this.s3.deleteObject(DeleteObjectRequest.builder().bucket(bucket).key(s3Object.key()).build());
            }

            listObjectsV2Request = ListObjectsV2Request.builder().bucket(bucket)
                    .continuationToken(listObjectsV2Response.nextContinuationToken())
                    .build();

        } while(listObjectsV2Response.isTruncated());
    }

    public void deleteBucket(String bucket) {

        DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder().bucket(bucket).build();
        this.s3.deleteBucket(deleteBucketRequest);
    }

    public void downloadS3Object(String bucket, String key) {
        this.s3.getObject(GetObjectRequest.builder().bucket(bucket).key(key).build(),
                ResponseTransformer.toFile(Paths.get("multiPartKey.jpg")));
    }

    public void listBucketObjects(S3Client s3, String bucketName ) {

        try {
            ListObjectsRequest listObjects = ListObjectsRequest
                    .builder()
                    .bucket(bucketName)
                    .build();

            ListObjectsResponse res = s3.listObjects(listObjects);
            List<S3Object> objects = res.contents();

            for (ListIterator iterVals = objects.listIterator(); iterVals.hasNext(); ) {
                S3Object myValue = (S3Object) iterVals.next();
                System.out.print("\n The name of the key is " + myValue.key());
                System.out.print("\n The object is " + calKb(myValue.size()) + " KBs");
                System.out.print("\n The owner is " + myValue.owner());
                System.out.println("\n The object name is: " + myValue.toString());
            }
        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
    //convert bytes to kbs
    private static long calKb(Long val) {
        return val/1024;
    }
}
