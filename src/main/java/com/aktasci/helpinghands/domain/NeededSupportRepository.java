package com.aktasci.helpinghands.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NeededSupportRepository extends CrudRepository<NeededSupport, Long> {
	public List<NeededSupport> findById(Long id);
}
