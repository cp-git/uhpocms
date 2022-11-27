package com.cpa.uhpocms;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminRoleApplication {
	private static final Logger logger = Logger.getLogger(AdminRoleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AdminRoleApplication.class, args);
		System.out.println("============Welcome==============");
		logger.info("in main class ");
	}

}
