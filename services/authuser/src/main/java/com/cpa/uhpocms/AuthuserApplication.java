package com.cpa.uhpocms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication

public class AuthuserApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {

		SpringApplication.run(AuthuserApplication.class, args);
		System.out.println("started..");
	}

}
