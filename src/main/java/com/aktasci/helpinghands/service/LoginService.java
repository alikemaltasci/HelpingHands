package com.aktasci.helpinghands.service;

import com.aktasci.helpinghands.domain.User;

public interface LoginService {
	
	public User login(String email, String password);

}
