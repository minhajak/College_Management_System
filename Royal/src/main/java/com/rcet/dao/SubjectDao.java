package com.rcet.dao;

import java.util.List;

import com.rcet.dto.Subject;

public interface SubjectDao {

	Subject get(int sid);

	List<Subject> getAll();

	Subject save(int did, int bid, Subject subject);

	Subject update(int sid, Subject subject);

	boolean delete(int sid);
}
