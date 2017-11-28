package br.usp.icmc.intermidia.esm.rest.api.client.util;

import java.io.File;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * Created by Brunaru on 13/03/2017. AWS S3 util.
 */
public class S3Mobile {

	private static final String SUFFIX = "/";

	private String awsAccessKeyId;
	private String awsSecretAccessKey;
	private String bucketName;
	private String folderName;
	private String s3Url;

	public S3Mobile(String awsAccessKeyId, String awsSecretAccessKey, String bucketName, String folderName,
			String s3Url) {
		super();
		this.awsAccessKeyId = awsAccessKeyId;
		this.awsSecretAccessKey = awsSecretAccessKey;
		this.bucketName = bucketName;
		this.folderName = folderName;
		this.s3Url = s3Url;
	}

	@SuppressWarnings("deprecation")
	public String uploadFile(String filePath) {
		try {
			AWSCredentials credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
			AmazonS3 s3client = new AmazonS3Client(credentials);
			File file = new File(filePath);
			s3client.putObject(new PutObjectRequest(bucketName, folderName + SUFFIX + file.getName(), file)
					.withCannedAcl(CannedAccessControlList.PublicRead));
			String url = s3Url + bucketName + SUFFIX + folderName + SUFFIX + file.getName();
			return url;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
