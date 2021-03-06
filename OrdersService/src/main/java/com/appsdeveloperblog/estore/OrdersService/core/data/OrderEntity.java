/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.estore.OrdersService.core.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.appsdeveloperblog.estore.OrdersService.core.model.OrderStatus;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
@DynamoDBTable(tableName = "orders")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 5313493413859894403L;

    @DynamoDBHashKey(attributeName = "orderId")
	@DynamoDBAutoGeneratedKey
    @Id
    @Column(unique = true)
    public String orderId;
    
    @DynamoDBAttribute
    private String productId;
    
    @DynamoDBAttribute
    private String userId;
    
    @DynamoDBAttribute
    private int quantity;
    
    @DynamoDBAttribute
    private String addressId;

    @DynamoDBAttribute
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
