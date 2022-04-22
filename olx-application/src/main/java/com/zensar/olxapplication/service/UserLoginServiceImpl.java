package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.olxapplication.entity.UserInformation;
import com.zensar.olxapplication.entity.UserLogin;
@Service
public class UserLoginServiceImpl implements UserLoginService {
	static List<UserInformation> userInformationList = new ArrayList<UserInformation>();

	@Override
	public String loginUser(UserLogin userLogin, String token) {
		if (userLogin.getUserName().equals("anand") && userLogin.getPassword().equals("anand123")) {
			token = "ry66540";
			return "login Successfull!!";
		} else {
		
		return "Authentication Failed!!";

	}
}}