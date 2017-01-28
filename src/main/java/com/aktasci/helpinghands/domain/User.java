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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String surname;
	private String email;
	private String password;
	private String phone;

	@OneToMany
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private List<Project> projects;

	@OneToMany
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private List<Supporting> supportings;

	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private Date createdDate;

	public User() {

	}

	public User(String name, String surname, String email, String password, String phone) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Supporting> getSupportings() {
		return supportings;
	}

	public void setSupportings(List<Supporting> supportings) {
		this.supportings = supportings;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", projects=" + projects + ", supportings=" + supportings
				+ ", createdDate=" + createdDate + "]";
	}

}
