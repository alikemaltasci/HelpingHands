package com.aktasci.helpinghands.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class NeededSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long projectId;

	private String name;

	private String description;

	private Long amount;

	private String unit;

	@OneToMany
	@JoinColumn(name = "neededSupportId", referencedColumnName = "id")
	private List<Supporting> supportings;

	public NeededSupport() {

	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<Supporting> getSupportings() {
		return supportings;
	}

	public void setSupportings(List<Supporting> supportings) {
		this.supportings = supportings;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "NeededSupport [id=" + id + ", projectId=" + projectId + ", name=" + name + ", description="
				+ description + ", amount=" + amount + ", unit=" + unit + ", supportings=" + supportings + "]";
	}

}
