package com.poc.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@DynamoDBTable(tableName = "Percentages")
@JsonApiResource(type = "percentages")
public class Percentages {

	@JsonApiId
	private String id;
	
	private String companyName;
	private String percentage;
	private String category;
	private String card;
	
	@DynamoDBAttribute
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@DynamoDBAttribute
	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

//	public Percentages(String id, String companyName, String percentage) {
//		this.id = id;
//		this.companyName = companyName;
//		this.percentage = percentage;
//	}

	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@DynamoDBAttribute
	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

}
