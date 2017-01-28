package com.aktasci.helpinghands.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aktasci.helpinghands.domain.User;
import com.aktasci.helpinghands.exception.UserAllreadyExistException;
import com.aktasci.helpinghands.exception.UserNotFoundException;
import com.aktasci.helpinghands.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public User save(@RequestBody User user) throws UserAllreadyExistException {
		return service.save(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) throws UserNotFoundException {
		service.delete(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findOne(@PathVariable("id") Long id) throws UserNotFoundException {
		return service.findOne(id);
	}
	
}
