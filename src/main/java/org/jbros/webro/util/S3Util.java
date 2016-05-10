package org.jbros.webro.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class S3Util {
    private String accessKey = "AKIAITL4T5MT4XBKSSYA";
    private String secretKey = "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";
    
    public static final String IMAGE_BASE_URL = "https://s3-us-west-2.amazonaws.com/webroprofile";
    public static final String IMAGE_BUCKET_NAME = "webroprofile";
     
    private AmazonS3 conn;
     
    public S3Util() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        this.conn = new AmazonS3Client(credentials);
        this.conn.setRegion(Region.getRegion(Regions.US_WEST_2));
    }
     
    // Bucket List
    public List<Bucket> getBucketList() {
        return conn.listBuckets();
    }
     
    // Bucket 생성 
    public Bucket createBucket(String bucketName) {
        return conn.createBucket(bucketName);
    }
     
    // 폴더 생성 (폴더는 파일명 뒤에 "/"를 붙여야한다.)
    public void createFolder(String bucketName, String folderName) {
        conn.putObject(bucketName, folderName + "/", new ByteArrayInputStream(new byte[0]), new ObjectMetadata());
    }
     
    // 파일 업로드
    public void putObject(String bucket, String key, InputStream inputStream) {
       ObjectMetadata objectMetaData = new ObjectMetadata();
       objectMetaData.setContentType("image/jpeg");
       
       conn.putObject(bucket, key, inputStream, objectMetaData);
    }
     
    // 파일 삭제
    public void fileDelete(String bucketName, String fileName) {
        conn.deleteObject(bucketName, fileName);
    }
     
    // 파일 URL
    public String getFileURL(String bucketName, String fileName) {
        return conn.generatePresignedUrl(new GeneratePresignedUrlRequest(bucketName, fileName)).toString();
    }

}