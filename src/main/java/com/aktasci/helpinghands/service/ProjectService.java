package com.aktasci.helpinghands.service;

import java.util.List;

import com.aktasci.helpinghands.domain.Project;
import com.aktasci.helpinghands.exception.ProjectAllreadyExistException;
import com.aktasci.helpinghands.exception.ProjectNotFoundException;

public interface ProjectService {
	
	public Project save(Project project) throws ProjectAllreadyExistException;
	public void delete(Long id) throws ProjectNotFoundException;
	public List<Project> findAll();
	public Project findOne(Long id) throws ProjectNotFoundException;
	public List<Project> findSupportedProjectsOfUser(Long userId);

}
