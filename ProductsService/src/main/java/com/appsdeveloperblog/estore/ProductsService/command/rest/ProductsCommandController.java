package com.appsdeveloperblog.estore.ProductsService.command.rest;

import java.util.UUID;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.estore.ProductsService.command.CreateProductCommand;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {
	
	@Autowired
	private CreateProductRepository createProductRepository;
	
	private final Environment env;
	private final CommandGateway commandGateway;
	
	@Autowired
	public ProductsCommandController(Environment env, CommandGateway commandGateway) {
		this.env = env;
		this.commandGateway = commandGateway;
	}
	
	@PostMapping
	public String createProduct(@Valid @RequestBody CreateProductRestModel createProducts) {
		
		CreateProductCommand createProductCommand = CreateProductCommand.builder()
		.price(createProducts.getPrice())
		.quantity(createProducts.getQuantity())
		.title(createProducts.getTitle())
		.productId(UUID.randomUUID().toString()).build();
		
		String returnValue;
		
		returnValue = commandGateway.sendAndWait(createProductCommand);
		
//		try {
//			returnValue = commandGateway.sendAndWait(createProductCommand);
//		} catch (Exception ex) {
//			return returnValue = ex.getLocalizedMessage();
//		}
		createProductRepository.save(createProductCommand);
		
		return returnValue;
	}
	
	
}
