package com.rcet.service;

import java.util.List;

import com.rcet.dao.SubjectDao;
import com.rcet.dao.imp.SubjectDaoImp;
import com.rcet.dto.Student;
import com.rcet.dto.Subject;

public class SubjectService {
	SubjectDao dao = new SubjectDaoImp();
	
	public List<Subject> getAllSubjects() {
		List<Subject> subjects = dao.getAll();
		return subjects;

	}

	public Subject getSubject(int sid) {
		Subject subject = dao.get(sid);
		if ( subject!= null) {
			System.out.println(" subject retrived successfully");
			return subject;
		} else {
			System.out.println("failed to retrive subject data");
			return null;
		}
	}

	public Subject saveStudent(int did,int bid, Subject subject) {
		Subject subject1 = dao.save(did,bid, subject);
		if (subject1 != null) {
			System.out.println("successfully saved the subject info");
			return subject1;
		} else {
			System.out.println("failed to save the subject info");
			return null;
		}
	}

	public void deleteStudent(int sid) {
		boolean flag = dao.delete(sid);
		if (flag) {
			System.out.println("successfully deleted subject");
		} else {
			System.out.println("failed to delete subject");
		}
	}

	public Subject updateStudent(int sid, Subject subject) {
		Subject subject1 = dao.update(sid, subject);
		if (subject1 != null) {
			System.out.println("subject updated");
			return subject1;
		} else {
			System.out.println("failed to update subject ");
			return null;
		}
	}

}
