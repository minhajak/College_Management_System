package com.rcet.dto;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	
	private String dname;
	
	private String location;

	@ManyToOne
	@JoinColumn
	private College college;
	
	@OneToMany(mappedBy = "department")
	private List<Teacher> teachers;

	@OneToMany(mappedBy = "department")
	private List<Batch> batchs;
	
	@OneToMany(mappedBy = "department")
	private List<Subject> subjects;
	
	

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Batch> getBatchs() {
		return batchs;
	}

	public void setBatchs(List<Batch> batchs) {
		this.batchs = batchs;
	}


}
