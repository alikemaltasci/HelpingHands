package com.aktasci.helpinghands.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	public Project findByName(String name);
	
	@Query("SELECT p FROM Project p where p.id in (SELECT n.projectId FROM NeededSupport n where n.id in (SELECT s.neededSupportId FROM Supporting s where s.userId = :userId))") 
    List<Project> findSupportedProjectsOfUser(@Param("userId") Long userId);

}
