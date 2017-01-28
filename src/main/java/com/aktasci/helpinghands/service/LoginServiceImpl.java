package com.aktasci.helpinghands.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktasci.helpinghands.domain.User;
import com.aktasci.helpinghands.domain.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User login(String email, String password) {

		User user = userRepository.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("Email>" + email + "User>" + user);
			//user = null; // TODO will throw exception
		}else{
			user = null;
		}
		return user;
	}

}
