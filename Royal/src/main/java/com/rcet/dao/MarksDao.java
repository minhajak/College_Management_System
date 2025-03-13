package com.rcet.dao;

import java.util.List;

import com.rcet.dto.Marks;

public interface MarksDao {
	public Marks get(int studId, int subId);

	public List<Marks> getAllMarkByOnePerson(int studId);

	public Marks update(Marks marks);

	public Marks save(int studId, int subId, Marks marks);

	public boolean delete(int studId, int subId);

	public List<Marks> getBySubjectId(int subId);

}
