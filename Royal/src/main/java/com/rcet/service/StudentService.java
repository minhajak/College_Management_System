package com.rcet.service;

import java.util.List;

import com.rcet.dao.StudentDao;
import com.rcet.dao.imp.StudentDaoImp;
import com.rcet.dto.Student;

public class StudentService {
	StudentDao dao = new StudentDaoImp();

	public List<Student> getAllStudents() {
		List<Student> students = dao.getAll();
		return students;

	}

	public Student getStudent(int sid) {
		Student student = dao.get(sid);
		if (student != null) {
			System.out.println("student data retrived successfully");
			return student;
		} else {
			System.out.println("failed to retrive student data");
			return null;
		}
	}

	public Student saveStudent(int bid, Student student) {
		Student student1 = dao.save(bid, student);
		if (student1 != null) {
			System.out.println("successfully saved the student info");
			return student1;
		} else {
			System.out.println("failed to save the student info");
			return null;
		}
	}

	public void deleteStudent(int sid) {
		boolean flag = dao.delete(sid);
		if (flag) {
			System.out.println("successfully deleted student");
		} else {
			System.out.println("failed to delete student");
		}
	}

	public Student updateStudent(int sid, Student student) {
		Student student1 = dao.update(sid, student);
		if (student1 != null) {
			System.out.println("student updated");
			return student1;
		} else {
			System.out.println("failed to update student ");
			return null;
		}
	}
	public List<Student> getStudentByBatchId(int bid){
		System.out.println("/n inside the service layer");
		return dao.getByBatchId(bid);
	}

}
