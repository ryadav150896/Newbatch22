package com.zensar.olxapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.entity.UserLogin;
import com.zensar.olxapplication.service.UserLoginService;

@RestController
public class UserLoginController {
	@Autowired
	private UserLoginService userLoginService;

	// login a user
	// http:localhost/5050/user/authenticate
	@PostMapping(value = "/user/authenticate", consumes =  {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
			, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> loginUser(@RequestBody UserLogin userLogin, String token) {

		 String loginResult=userLoginService.loginUser(userLogin, token);
		if(loginResult.equals("login Successfull!!")) {
			return new ResponseEntity<String>(loginResult + token, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(loginResult, HttpStatus.BAD_REQUEST);
		
		
	}
}
}