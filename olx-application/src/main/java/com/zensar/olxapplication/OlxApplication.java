package com.zensar.olxapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.olxapplication.entity.UserInformation;

@SpringBootApplication
public class OlxApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxApplication.class, args);
		UserInformation user=new UserInformation();
		
	}

}
