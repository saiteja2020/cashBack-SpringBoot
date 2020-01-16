package com.poc.DynamoDBRepository;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.poc.model.Percentages;

@Repository
public class PercentagesDynamoDBRepositoryImpl {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;


	public Percentages insertIntoDynamoDB(Percentages percentages) {
		dynamoDBMapper.save(percentages);
		return dynamoDBMapper.load(Percentages.class, percentages.getId());
	}

	public Percentages getPercentage(String id) {
		return dynamoDBMapper.load(Percentages.class, id);
	}
	
	public PaginatedScanList<Percentages> findAll(){
		return dynamoDBMapper.scan(Percentages.class, new DynamoDBScanExpression());
	}

//public void updatePercetages(Percentages percentages) {
//	try {
//		dynamoDBMapper.save(percentages, buildDynamoDBSaveExpression(percentages));
//	} catch (ConditionalCheckFailedException exception){
//		System.out.println("Percentages Save failed!!!!!!!!!!!");
//	}
//}
	public void deletePerecentages(Percentages percentages) {
		dynamoDBMapper.delete(percentages);
	}

//public DynamoDBSaveExpression buildDynamoDBSaveExpression(Percentages percentages) {
//	DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
//	Map<String, ExceptedAttributeValues>
//}
}
