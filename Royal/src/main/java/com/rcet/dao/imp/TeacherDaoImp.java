package com.rcet.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rcet.dao.TeacherDao;
import com.rcet.dto.Department;
import com.rcet.dto.Subject;
import com.rcet.dto.Teacher;

public class TeacherDaoImp implements TeacherDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("minhaj");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Teacher save(int did, Teacher teacher) {
		Department department = entityManager.find(Department.class, did);
		Subject subject = entityManager.find(Subject.class, teacher.getSubject().getSid());
		if (department != null) {
			teacher.setDepartment(department);
			department.getTeachers().add(teacher);
			subject.setTeacher(teacher);
			teacher.setSubject(subject);

			entityTransaction.begin();
			entityManager.persist(teacher);
			entityTransaction.commit();
			return teacher;

		}
		return null;
	}

	@Override
	public List<Teacher> getAll() {
		Query query = entityManager.createQuery("select e from Teacher e");
		List<Teacher> teachers = query.getResultList();
		return teachers;
	}

	@Override
	public Teacher get(int tid) {
		Teacher teacher = entityManager.find(Teacher.class, tid);
		return teacher;
	}

	@Override
	public Teacher update(int tid, Teacher teacher) {
		Teacher teacher1 = entityManager.find(Teacher.class, tid);
		Subject subject = entityManager.find(Subject.class, teacher.getSubject().getSid());
		if (teacher1 != null) {
			teacher1.setName(teacher.getName());
			teacher1.setAge(teacher.getAge());
			teacher1.setGender(teacher.getGender());
			teacher1.setPhone_no(teacher.getPhone_no());
			teacher1.setEmail(teacher.getEmail());
			teacher1.setSubject(subject);
			subject.setTeacher(teacher1);

			entityTransaction.begin();
			entityManager.merge(teacher1);
			entityManager.merge(subject);
			entityTransaction.commit();
			return teacher1;
		}
		return null;
	}

	@Override
	public boolean delete(int tid) {
		Teacher teacher = entityManager.find(Teacher.class, tid);
		if (teacher != null) {
			entityTransaction.begin();
			entityManager.remove(teacher);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Teacher> getByDid(int did) {
		Query query = entityManager.createQuery("select e from Teacher e where department_did=?1");
		query.setParameter(1, did);
		return query.getResultList();
	}

}
