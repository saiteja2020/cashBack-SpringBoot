package com.poc.KatharsisRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.poc.DynamoDBRepository.PercentagesDynamoDBRepositoryImpl;
import com.poc.model.Percentages;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class PercentagesKatharsisRepositoryImpl extends ResourceRepositoryBase<Percentages, String> {
	
	@Autowired
	private PercentagesDynamoDBRepositoryImpl percentagesServiceRepository;

//	private Map<Integer, Percentages> percentages = new HashMap<>();
 public PercentagesKatharsisRepositoryImpl(){
	 super(Percentages.class);

 }
 
 
	@Override
	public ResourceList<Percentages> findAll(QuerySpec querySpec) {
		return querySpec.apply(percentagesServiceRepository.findAll());
	}


	@Override
	public Percentages findOne(String id, QuerySpec querySpec) {
		// TODO Auto-generated method stub
//		return super.findOne(id, querySpec);
		return percentagesServiceRepository.getPercentage(id);
//		return null;
//		return querySpec.apply(percentagesServiceRepository.findById(id));
	}


 @Override
public synchronized  <S extends Percentages> S save(S resource) {
	// TODO Auto-generated method stub
	return (S) percentagesServiceRepository.insertIntoDynamoDB(resource);
}


	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Percentages percentages = percentagesServiceRepository.getPercentage(id);
		percentagesServiceRepository.deletePerecentages(percentages);
//		percentagesServiceRepository.deleteById(id);
	}
	

}
