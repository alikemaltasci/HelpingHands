package com.aktasci.helpinghands.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aktasci.helpinghands.domain.User;
import com.aktasci.helpinghands.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public User login(@RequestBody User user) {
		return loginService.login(user.getEmail(), user.getPassword());
	}

}
