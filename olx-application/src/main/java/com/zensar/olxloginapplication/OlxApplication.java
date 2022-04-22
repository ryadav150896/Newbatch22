package com.zensar.olxloginapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.olxloginapplication.entity.UserInformation;

@SpringBootApplication
public class OlxApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxApplication.class, args);
		UserInformation user=new UserInformation();
		
	}

}
