package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyappMainServerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappMainServerServiceApplication.class, args);
	}

}
