package com.example.photogallerydiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotoGalleryDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoGalleryDiscoveryServiceApplication.class, args);
	}

}
