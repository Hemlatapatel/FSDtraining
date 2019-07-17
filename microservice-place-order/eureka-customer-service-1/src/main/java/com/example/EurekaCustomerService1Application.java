package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaCustomerService1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCustomerService1Application.class, args);
	}

}
