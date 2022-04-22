package com.zensar.olxapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.entity.UserInformation;
import com.zensar.olxapplication.service.UserInformationService;

@RestController
public class UserInformationController {
	@Autowired
	private UserInformationService userInformationService;

	// get the user
	// http:localhost:5050/user
	@GetMapping(value = "/user", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	// @RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<UserInformation> getUserInformation(@RequestHeader("auth-token") String token) {
		return userInformationService.getUserInformation(token);
	}

	// add new user
	// http:localhost:5050/user
	@PostMapping(value = "/user", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserInformation resgisterUser(@RequestBody UserInformation userData) {
		return userInformationService.resgisterUser(userData);
	}

	// to delete existing user
	// http:localhost:5050/user/logout
	@DeleteMapping("/user/logout")
	public ResponseEntity<String> logoutUser(@RequestHeader("auth-token") String token) {
		String logoutResult = userInformationService.logoutUser(token);

		if (logoutResult.equals("logout successfuly")) {
			return new ResponseEntity<String>("logout successfuly", HttpStatus.ACCEPTED);

		} else {

			return new ResponseEntity<String>("failed to logout", HttpStatus.BAD_REQUEST);

		}
	}
}