package com.rcet.dao;

import java.util.List;

import com.rcet.dto.Student;

public interface StudentDao {

	Student save(int bid, Student student);

	Student get(int sid);

	List<Student> getAll();

	boolean delete(int sid);

	Student update(int sid, Student student);
	
	List<Student> getByBatchId(int bid);

}
