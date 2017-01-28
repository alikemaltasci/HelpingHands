package com.aktasci.helpinghands.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktasci.helpinghands.domain.Supporting;
import com.aktasci.helpinghands.domain.SupportingRepository;

@Service
public class SupportingServiceImpl implements SupportingService {

	@Autowired
	SupportingRepository repo;
	
	@Override
	public Supporting save(Supporting supporting) {
		return repo.save(supporting);
		
	}

	@Override
	public void delete(Long id) {
		repo.delete(id);
	}

}
