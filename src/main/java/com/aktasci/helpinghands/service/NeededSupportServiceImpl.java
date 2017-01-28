package com.aktasci.helpinghands.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktasci.helpinghands.domain.NeededSupport;
import com.aktasci.helpinghands.domain.NeededSupportRepository;

@Service
public class NeededSupportServiceImpl implements NeededSupportService {

	@Autowired
	NeededSupportRepository repo;

	@Override
	public NeededSupport save(NeededSupport neededSupport) {
		return repo.save(neededSupport);
	}

	@Override
	public void delete(Long id) {
		repo.delete(id);

	}

}
