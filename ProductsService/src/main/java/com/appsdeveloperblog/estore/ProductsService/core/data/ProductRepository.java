package com.appsdeveloperblog.estore.ProductsService.core.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Repository
public class ProductRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public ProductEntity save(ProductEntity product) {
		dynamoDBMapper.save(product);
		return product;
	}
}
