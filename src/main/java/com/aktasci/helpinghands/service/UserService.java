package com.aktasci.helpinghands.service;

import java.util.List;

import com.aktasci.helpinghands.domain.User;
import com.aktasci.helpinghands.exception.UserAllreadyExistException;
import com.aktasci.helpinghands.exception.UserNotFoundException;

public interface UserService {

	public User save(User user) throws UserAllreadyExistException;

	public void delete(Long id) throws UserNotFoundException;
	
	public List<User> findAll();
	
	public User findOne(Long id) throws UserNotFoundException;

}
