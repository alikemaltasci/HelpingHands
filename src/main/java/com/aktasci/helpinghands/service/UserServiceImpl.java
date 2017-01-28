package com.aktasci.helpinghands.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktasci.helpinghands.domain.User;
import com.aktasci.helpinghands.domain.UserRepository;
import com.aktasci.helpinghands.exception.UserAllreadyExistException;
import com.aktasci.helpinghands.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public User save(User user) throws UserAllreadyExistException {

		if (user.getId() == null) { // insert operation
			User existing = repo.findByEmail(user.getEmail());
			if (existing != null) {
				throw new UserAllreadyExistException();
			}

		}
		return repo.save(user);
	}

	@Override
	public void delete(Long id) throws UserNotFoundException {
		User existing = repo.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException();
		}

		repo.delete(id);
	}

	@Override
	public List<User> findAll() {
		List<User> userList = (List<User>) repo.findAll();
		return userList;
	}

	@Override
	public User findOne(Long id) throws UserNotFoundException {
		User existing = repo.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException();
		}
		return existing;
	}

}
