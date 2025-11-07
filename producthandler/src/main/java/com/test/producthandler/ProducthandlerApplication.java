package com.test.producthandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducthandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducthandlerApplication.class, args);
	}

}
