package com.appsdeveloperblog.estore.OrdersService.core.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.appsdeveloperblog.estore.OrdersService.command.commands.CreateOrderCommand;

@Repository
public class OrderCreateRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public OrderEntity save(OrderEntity orderEntity) {
		dynamoDBMapper.save(orderEntity);
		return orderEntity;
	}

	public OrderEntity load(String orderId) {
		return dynamoDBMapper.load(OrderEntity.class, orderId);
	}

}
