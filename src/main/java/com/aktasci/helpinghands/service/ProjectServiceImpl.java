package com.aktasci.helpinghands.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktasci.helpinghands.domain.NeededSupport;
import com.aktasci.helpinghands.domain.NeededSupportRepository;
import com.aktasci.helpinghands.domain.Project;
import com.aktasci.helpinghands.domain.ProjectRepository;
import com.aktasci.helpinghands.domain.SupportingRepository;
import com.aktasci.helpinghands.exception.ProjectAllreadyExistException;
import com.aktasci.helpinghands.exception.ProjectNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	NeededSupportRepository neededSupportRepo;

	@Autowired
	SupportingRepository supportingRepository;

	@Override
	public Project save(Project project) throws ProjectAllreadyExistException {
		Project existing = projectRepo.findByName(project.getName());
		if (existing != null) {
			throw new ProjectAllreadyExistException();
		}

		List<NeededSupport> neededSupports = project.getNeededSupports();

		project.setNeededSupports(null);
		Project savedProject = projectRepo.save(project);

		for (NeededSupport neededSupport : neededSupports) {
			neededSupport.setProjectId(savedProject.getId());
			neededSupportRepo.save(neededSupport);
		}

		savedProject = projectRepo.findOne(savedProject.getId());

		return savedProject;
	}

	@Override
	public void delete(Long id) throws ProjectNotFoundException {
		Project existing = projectRepo.findOne(id);
		if (existing == null) {
			throw new ProjectNotFoundException();
		}
		projectRepo.delete(id);
	}

	@Override
	public List<Project> findAll() {
		List<Project> projects = (List<Project>) projectRepo.findAll();
		return projects;
	}

	@Override
	public Project findOne(Long id) throws ProjectNotFoundException {

		Project existing = projectRepo.findOne(id);
		if (existing == null) {
			throw new ProjectNotFoundException();
		}
		return existing;
	}

	@Override
	public List<Project> findSupportedProjectsOfUser(Long userId) {
		return projectRepo.findSupportedProjectsOfUser(userId);
	}

}
