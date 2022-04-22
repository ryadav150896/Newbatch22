package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.zensar.olxapplication.entity.UserInformation;

@Service
public class UserInformationServiceImpl implements UserInformationService {

	static List<UserInformation> userInformationList = new ArrayList<UserInformation>();

	
	public List<UserInformation> getUserInformation(String token) {
		if (token.equals("ry66540")) {
			return userInformationList;

		}
		return null;
	}

	
	public UserInformation resgisterUser(UserInformation userData) {
		userInformationList.add(userData);
		return userData;
	}

	
	public String logoutUser(String token) {
		for (UserInformation user : userInformationList) {

			if (token.equals("ry66540")) {
				userInformationList.remove(user);
				return "logout successfuly";
			} else {
				return "failed to logout";

			}
		}
		return null;
	}
}
