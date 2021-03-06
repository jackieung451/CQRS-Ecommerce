/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.paymentservice.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Table;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@Data
@Entity
@DynamoDBTable(tableName = "payments")
public class PaymentEntity implements Serializable {
    private static final long serialVersionUID = 5313493413859894403L;

	@DynamoDBHashKey(attributeName = "paymentId")
	@DynamoDBAutoGeneratedKey
    @Id
    private String paymentId;

    @Column
    @DynamoDBAttribute
    public String orderId;


}
