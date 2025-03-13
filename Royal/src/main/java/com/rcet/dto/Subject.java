package com.rcet.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;

	private String name;

	@ManyToMany(mappedBy = "subjects")
	private List<Student> students;

	@OneToOne(mappedBy = "subject")
	private Teacher teacher;

	@ManyToOne
	@JoinColumn
	private Department department;

	@OneToOne
	@JoinColumn
	private Batch batch;
	
	@OneToMany(mappedBy = "subject")
	private List<Marks> subjectMarks;


	
	
	
	
	public List<Marks> getSubjectMarks() {
		return subjectMarks;
	}

	public void setSubjectMarks(List<Marks> subjectMarks) {
		this.subjectMarks = subjectMarks;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


}
