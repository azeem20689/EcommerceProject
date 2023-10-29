package com.azeem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.azeem.entities")
public class AzeemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzeemApplication.class, args);
		System.out.println("Application Started !!");
	}

}
