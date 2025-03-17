package com.example.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantManagementMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantManagementMsApplication.class, args);
	}

}
