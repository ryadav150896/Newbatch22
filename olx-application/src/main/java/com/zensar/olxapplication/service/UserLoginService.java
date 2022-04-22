package com.zensar.olxapplication.service;

import com.zensar.olxapplication.entity.UserLogin;

public interface UserLoginService {
	
	String loginUser(UserLogin userLogin, String token) ;

}
