package com.aktasci.helpinghands.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aktasci.helpinghands.domain.Project;
import com.aktasci.helpinghands.exception.ProjectAllreadyExistException;
import com.aktasci.helpinghands.exception.ProjectNotFoundException;
import com.aktasci.helpinghands.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService service;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Project save(@RequestBody Project project) throws ProjectAllreadyExistException {
		return service.save(project);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Project> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Project findOne(@PathVariable("id") Long id) throws ProjectNotFoundException {
		return service.findOne(id);
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public List<Project> findSupportedProjectsOfUser(@PathVariable("userId") Long userId) throws ProjectNotFoundException {
		return service.findSupportedProjectsOfUser(userId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) throws ProjectNotFoundException {
		service.delete(id);
	}

}
