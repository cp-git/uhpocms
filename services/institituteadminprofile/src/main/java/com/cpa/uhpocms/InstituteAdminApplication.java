package com.cpa.uhpocms;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class InstituteAdminApplication extends SpringBootServletInitializer {
	private static final Logger logger = Logger.getLogger(InstituteAdminApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InstituteAdminApplication.class, args);
		System.out.println("Welcome to spring boot");
		logger.info("in Main class");
	}
	
	 @Bean
	    public ResourceLoader resourceLoader() {
	        return new DefaultResourceLoader();
	    }

	

}
