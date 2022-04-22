package com.zensar.olxloginapplication.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.zensar.olxloginapplication.entity.UserInformation;

@RestController
public class UserInformationController {

	static List<UserInformation> userInformationList = new ArrayList<UserInformation>();
	/*
	 * static {
	 * 
	 * userInformationList.add( new UserInformation(1, "ravi", "yadav", "raviy",
	 * "ravi@07", "iraviyadav15@gmail.com", "8770906899")); userInformationList
	 * .add(new UserInformation(2, "aman", "jain", "groot", "groot@07",
	 * "jainaman15@gmail.com", "8770908764")); }
	 */

	// get the user
	// http:localhost:5050/user
	@GetMapping(value = "/user", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	// @RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<UserInformation> getUserInformation(@RequestHeader("auth-token") String token) {
		if (token.equals("ry66540")) {
			return userInformationList;

		}
		return null;
	}

	// add new user
	// http:localhost:5050/user
	@PostMapping(value = "/user", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserInformation resgisterUser(@RequestBody UserInformation userData) {
		userInformationList.add(userData);
		return userData;
	}

	
	// to delete existing user
	// http:localhost:5050/user/logout
	@DeleteMapping("/user/logout")
	public ResponseEntity<String> logoutUser(@RequestHeader("auth-token") String token) {

		for (UserInformation user : userInformationList) {

			if (token.equals("ry66540")) {
				userInformationList.remove(user);

			}
			return new ResponseEntity<String>("failed to logout", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("logout successfuly", HttpStatus.ACCEPTED);

	}

}