package com.poc.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

@Configuration
@EnableDynamoDBRepositories
public class DynamoDBConfig {

	@Value("${amazon.dynamodb.endpoint}")
	private String amazonDynamoDBEndpoint;
	
	@Value("${amazon.aws.accesskey}")
	private String accessKey;
	
	@Value("${amazon.aws.secretkey}")
	private String secretKey;
	
	@Value("${amazon.aws.region}")
	private String region;
	
//	@Bean
//	public AWSCredentials awsCredentials() {
//		return new BasicAWSCredentials(accessKey,secretKey);
//	}
//	
//
//	public AmazonDynamoDB amazonDynamoDBConfig() {
////		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(awsCredentials());
////		
////		if(!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
////			amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
////		}
////		
////		return amazonDynamoDB;
//		return AmazonDynamoDBClientBuilder.standard()
//				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint, region))
//				.withCredentials(new AWSStaticCredentialsProvider( new BasicAWSCredentials(accessKey, secretKey)))
//				.build();
//	}
//	@Bean
//	public DynamoDBMapper  DynamoDBMapper () {
//		return new DynamoDBMapper(amazonDynamoDBConfig());
//	}
	  @Bean
	    public AWSCredentials amazonAWSCredentials() {
	        return new BasicAWSCredentials(accessKey, secretKey);
	    }
	    @Bean
	    public DynamoDBMapperConfig dynamoDBMapperConfig() {
	        return DynamoDBMapperConfig.DEFAULT;
	    }
	    @Bean
	    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
	        return new DynamoDBMapper(amazonDynamoDB, config);
	    }
	    @Bean
	    public AmazonDynamoDB amazonDynamoDB() {
	        return AmazonDynamoDBClientBuilder
	                .standard()
	                .withCredentials(amazonAWSCredentialsProvider())
	                .withRegion(region)
	                .build();
	    }
	    @Bean
	    public DynamoDB dynamoDB() {
	        return new DynamoDB(amazonDynamoDB());
	    }
	    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
	        return new AWSStaticCredentialsProvider(amazonAWSCredentials());
	    }

}
