package com.zensar.olxapplication.service;

import java.util.List;

import com.zensar.olxapplication.entity.UserInformation;

public interface UserInformationService {
	
	List<UserInformation> getUserInformation( String token); 
	UserInformation resgisterUser( UserInformation userData);
	String logoutUser( String token);

}
