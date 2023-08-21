package com.example.authbes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AuthbesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthbesApplication.class, args);
	}

}
