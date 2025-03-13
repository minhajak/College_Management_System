package com.rcet.service;

import java.util.List;

import com.rcet.dao.TeacherDao;
import com.rcet.dao.imp.TeacherDaoImp;
import com.rcet.dto.Teacher;

public class TeacherService {
	TeacherDao dao = new TeacherDaoImp();

	public List<Teacher> getAllTeachers() {
		List<Teacher> teachers = dao.getAll();
		return teachers;
	}

	public Teacher geTeacher(int tid) {
		Teacher teacher = dao.get(tid);
		if (teacher != null) {
			System.out.println("teacher data retrived successfully");
			return teacher;
		} else {
			System.out.println("failed to retrive teacher data");
			return null;
		}
	}

	public Teacher saveTeacher(int did, Teacher teacher) {
		Teacher teacher1 = dao.save(did, teacher);
		if (teacher1 != null) {
			System.out.println("successfully saved the teacher info");
			return teacher1;
		} else {
			System.out.println("failed to save the teacher info");
			return null;
		}
	}

	public void deleteTeacher(int tid) {
		boolean flag = dao.delete(tid);
		if (flag) {
			System.out.println("successfully deleted teacher");
		} else {
			System.out.println("failed to delete teacher");
		}
	}

	public Teacher updateTeacher(int tid, Teacher teacher) {
		Teacher teacher1 = dao.update(tid, teacher);
		if (teacher1 != null) {
			System.out.println("department updated");
			return teacher1;
		} else {
			System.out.println("failed to update department ");
			return null;
		}
	}

	public List<Teacher> getTeachersByDepartmentId(int did) {
		return dao.getByDid(did);
	}

}
