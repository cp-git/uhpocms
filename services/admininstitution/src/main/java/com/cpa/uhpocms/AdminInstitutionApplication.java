package com.cpa.uhpocms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AdminInstitutionApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AdminInstitutionApplication.class, args);
		System.out.println("hello");
	}

} 
