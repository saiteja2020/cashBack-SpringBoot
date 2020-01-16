//package com.poc.application;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.poc.DynamoDBRepository.PercentagesDynamoDBRepositoryImpl;
//import com.poc.model.Percentages;
//
//import io.katharsis.queryspec.QuerySpec;
//import io.katharsis.repository.ResourceRepositoryBase;
//import io.katharsis.resource.list.ResourceList;
//
//@Component
//public class PercentagesKatharsisRepositoryImplbck extends ResourceRepositoryBase<Percentages, String> {
//	
//	@Autowired
//	private PercentagesDynamoDBRepositoryImpl percentagesServiceRepository;
//
//	private Map<Integer, Percentages> percentages = new HashMap<>();
//// public PercentagesKatharsisRepositoryImplbck(){
////	 super(Percentages.class);
////	 percentages.put(1, new Percentages());
////	 percentages.put(2, new Percentages());
////	 percentages.put(3, new Percentages());
//// }
// 
// 
//	@Override
//	public ResourceList<Percentages> findAll(QuerySpec querySpec) {
//		return querySpec.apply(percentages.values());
//	}
//
//
//	@Override
//	public Percentages findOne(String id, QuerySpec querySpec) {
//		// TODO Auto-generated method stub
////		return super.findOne(id, querySpec);
//		return percentagesServiceRepository.getPercentage(id);
//	}
//
//
//	@Override
//	public <S extends Percentages> S save(S resource) {
//		// TODO Auto-generated method stub
//		return super.save(resource);
//	}
//
//
//	@Override
//	public <S extends Percentages> S create(S resource) {
//		// TODO Auto-generated method stub
//		return super.create(resource);
//	}
//
//
//	@Override
//	public void delete(String id) {
//		// TODO Auto-generated method stub
//		Percentages percentages = percentagesServiceRepository.getPercentage(id);
//		percentagesServiceRepository.deletePerecentages(percentages);
//	}
//	
//
//}
