package com.appsdeveloperblog.estore.ProductsService.command.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.appsdeveloperblog.estore.ProductsService.command.CreateProductCommand;

@Repository
public class CreateProductRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public CreateProductCommand save(CreateProductCommand createProducts) {
		dynamoDBMapper.save(createProducts);
		return createProducts;
	}
}
