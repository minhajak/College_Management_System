package com.rcet.dao;

import java.util.List;

import com.rcet.dto.Teacher;

public interface TeacherDao {
	Teacher save(int did, Teacher teacher);

	List<Teacher> getAll();

	Teacher get(int tid);

	Teacher update(int tid, Teacher teacher);

	boolean delete(int tid);

	List<Teacher> getByDid(int did);

}
