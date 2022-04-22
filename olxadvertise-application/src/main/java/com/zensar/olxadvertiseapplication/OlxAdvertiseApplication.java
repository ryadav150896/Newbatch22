package com.zensar.olxadvertiseapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.olxadvertiseapplication.entity.Advertisement;

@SpringBootApplication
public class OlxAdvertiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxAdvertiseApplication.class, args);
		
		Advertisement ad=new Advertisement();
		
	}

}
