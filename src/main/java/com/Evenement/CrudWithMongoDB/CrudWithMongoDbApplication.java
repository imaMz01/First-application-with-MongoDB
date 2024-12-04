package com.Evenement.CrudWithMongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CrudWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudWithMongoDbApplication.class, args);
	}

}
