package com.appsdeveloperblog.paymentservice.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Repository
public class PaymentsRepository {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	
	public PaymentEntity save(PaymentEntity payment) {
		dynamoDBMapper.save(payment);
		return payment;
	}
	
}
