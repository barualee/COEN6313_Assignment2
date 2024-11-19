package com.assignment2.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class OrderserviceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}

}
