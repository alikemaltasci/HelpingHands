package com.aktasci.helpinghands.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SupportingRepository extends CrudRepository<Supporting, Long> {
	public List<Supporting> findByUserId(Long userId);
}
