package com.zensar.olxloginapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxloginapplication.entity.UserLogin;

@RestController
public class UserLoginController {
	//login a user
	//http:localhost/5050/user/authenticate
	@PostMapping(value="/user/authenticate",consumes={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> loginUser(@RequestBody UserLogin userLogin, String token) {
		if (userLogin.getUserName().equals("anand") && userLogin.getPassword().equals("anand123")) {
			token="ry66540";
			
		} else {
			return new ResponseEntity<String>("Authentication Failed!!",HttpStatus.BAD_GATEWAY) ;
			
		}return new ResponseEntity<String>("Login Successful : "+token,HttpStatus.OK);
	}
}
