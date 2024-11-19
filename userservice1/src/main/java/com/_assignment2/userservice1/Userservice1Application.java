package com._assignment2.userservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Userservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Userservice1Application.class, args);
	}

}
