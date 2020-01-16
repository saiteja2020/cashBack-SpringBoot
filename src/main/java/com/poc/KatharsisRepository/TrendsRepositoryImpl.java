package com.poc.KatharsisRepository;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.poc.model.Trends;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class TrendsRepositoryImpl extends ResourceRepositoryBase<Trends, Integer>{

	private String message = "No Trends";
	private Map<Integer, Trends> trends = new HashMap<>();
	
	
	public TrendsRepositoryImpl() {
		super(Trends.class);
	}

	@Override
	public ResourceList<Trends> findAll(QuerySpec querySpec) {
  
		return querySpec.apply(trends.values());
	}
}
