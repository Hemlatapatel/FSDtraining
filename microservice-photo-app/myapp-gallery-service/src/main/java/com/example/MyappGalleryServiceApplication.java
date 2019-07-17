package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MyappGalleryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappGalleryServiceApplication.class, args);
	}

	@Configuration
	class configure {
		@Bean
		@LoadBalanced		// Load balance between service instances running at different ports.

		public RestTemplate restTemplate() {
		
			return new RestTemplate();
		}
		
	}
	
	
}
