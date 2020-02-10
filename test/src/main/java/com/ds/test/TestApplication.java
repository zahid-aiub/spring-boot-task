package com.ds.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		System.out.println(":::::::::::::::::::::::::::::::::::::::::");
		System.out.println("Application is Running");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::");
	}

}
