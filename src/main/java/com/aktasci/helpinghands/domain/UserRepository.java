package com.aktasci.helpinghands.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByEmail(String email);

}
