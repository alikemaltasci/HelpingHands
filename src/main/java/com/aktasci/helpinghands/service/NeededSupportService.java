package com.aktasci.helpinghands.service;

import com.aktasci.helpinghands.domain.NeededSupport;

public interface NeededSupportService{

	public NeededSupport save(NeededSupport neededSupport);
	public void delete(Long id);
}
