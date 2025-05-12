package com.training.microservice.buchung_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BuchungServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuchungServiceApplication.class, args);
	}

}
