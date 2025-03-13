package com.rcet.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rcet.dao.StudentDao;
import com.rcet.dto.Batch;
import com.rcet.dto.Student;

public class StudentDaoImp implements StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("minhaj");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Student save(int bid, Student student) {
		Batch batch = entityManager.find(Batch.class, bid);
		if (batch != null) {
			batch.getStudents().add(student);
			student.setBatch(batch);

			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
			return student;

		}
		return null;
	}

	@Override
	public Student get(int sid) {
		Student student = entityManager.find(Student.class, sid);
		return student;
	}

	@Override
	public List<Student> getAll() {
		Query query = entityManager.createQuery("select e from Student e");
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public boolean delete(int sid) {
		Student student = entityManager.find(Student.class, sid);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public Student update(int sid, Student student) {
		Student student1 = entityManager.find(Student.class, sid);
		if (student1 != null) {
			student1.setName(student.getName());
			student1.setAge(student.getAge());
			student1.setGender(student.getGender());
			student1.setEmail(student.getEmail());
			student1.setPhone_no(student.getPhone_no());

			entityTransaction.begin();
			entityManager.merge(student1);
			entityTransaction.commit();
			return student1;
		}
		return null;
	}

	@Override
	public List<Student> getByBatchId(int bid) {
		System.out.println("/n inside the daoImp");
		Query query = entityManager.createQuery("select e from Student e where batch_bid=?1");
		query.setParameter(1, bid);
		List<Student> students = query.getResultList();
		return students;

	}

}
