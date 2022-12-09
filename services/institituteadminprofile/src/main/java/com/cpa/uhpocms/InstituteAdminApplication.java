package com.cpa.uhpocms;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InstituteAdminApplication {
	  private static final Logger loggger = Logger.getLogger(InstituteAdminApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(InstituteAdminApplication.class, args);
		System.out.println("Welcome to spring boot");
		loggger.info("in Main class");
	}

}
