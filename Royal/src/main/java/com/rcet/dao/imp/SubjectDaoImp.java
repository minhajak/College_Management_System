package com.rcet.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rcet.dao.SubjectDao;
import com.rcet.dto.Batch;
import com.rcet.dto.Department;
import com.rcet.dto.Student;
import com.rcet.dto.Subject;
import com.rcet.dto.Teacher;

public class SubjectDaoImp implements SubjectDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("minhaj");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Subject get(int sid) {
		Subject subject = entityManager.find(Subject.class, sid);
		return subject;
	}

	@Override
	public List<Subject> getAll() {
		Query query = entityManager.createQuery("select e from Subject e");
		List<Subject> subjects = query.getResultList();
		return subjects;
	}

	@Override
	public Subject save(int did,int bid, Subject subject) {
		Department department = entityManager.find(Department.class, did);
		Batch batch = entityManager.find(Batch.class, bid);
		if (department != null) {
			department.getSubjects().add(subject);
			batch.getSubjects().add(subject);
			subject.setDepartment(department);
			subject.setBatch(batch);
			
			entityTransaction.begin();
			entityManager.persist(subject);
			entityTransaction.commit();
			return subject;

		}
		return null;
	}

	@Override
	public Subject update(int sid, Subject subject) {
		Subject subject1 = entityManager.find(Subject.class, sid);
		if (subject1 != null) {
			subject1.setName(subject.getName());

			entityTransaction.begin();
			entityManager.merge(subject1);
			entityTransaction.commit();
			return subject1;
		}
		return null;
	}

	@Override
	public boolean delete(int sid) {
		Subject subject = entityManager.find(null, entityManager);
		if (subject != null) {
			entityTransaction.begin();
			entityManager.remove(subject);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
