package com.rcet.service;

import java.util.List;

import com.rcet.dao.MarksDao;
import com.rcet.dao.imp.MarksDaoImp;
import com.rcet.dto.Marks;

public class MarksService {
	MarksDao dao = new MarksDaoImp();

	public Marks getByIds(int studId, int subId) {
		return (Marks) dao.get(studId, subId);
	}

	public void saveMarks(int studId, int subId, Marks marks) {

		Marks marks2 = dao.save(studId, subId, marks);
		if (marks2 != null) {
			System.out.println("marks created");
		} else {
			System.out.println("failed to create marks");
		}

	}

	public List<Marks> getMarksBySubjectId(int subId) {
		return dao.getBySubjectId(subId);
	}

	public List<Marks> getMarksByStudentId(int studId) {
		return dao.getAllMarkByOnePerson(studId);

	}

	public Marks updateMarks(Marks marks) {
		Marks marks2 = dao.update(marks);
		return marks2;

	}
}
