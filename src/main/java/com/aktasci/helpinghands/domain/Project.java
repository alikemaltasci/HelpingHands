package com.aktasci.helpinghands.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long userId;

	private String name;
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private Date createdDate;

	@OneToMany
	@JoinColumn(name = "projectId", referencedColumnName = "id")
	private List<NeededSupport> neededSupports;

	public Project() {

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<NeededSupport> getNeededSupports() {
		return neededSupports;
	}

	public void setNeededSupports(List<NeededSupport> neededSupports) {
		this.neededSupports = neededSupports;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", userId=" + userId + ", name=" + name + ", description=" + description
				+ ", createdDate=" + createdDate + ", neededSupports=" + neededSupports + "]";
	}

}
