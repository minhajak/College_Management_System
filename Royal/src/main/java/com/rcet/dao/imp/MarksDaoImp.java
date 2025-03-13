package com.rcet.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rcet.dao.MarksDao;
import com.rcet.dto.Marks;
import com.rcet.dto.Student;
import com.rcet.dto.Subject;

public class MarksDaoImp implements MarksDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("minhaj");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Marks get(int studId, int subId) {
		entityTransaction.begin();
		Query query = entityManager.createQuery("select e from Marks e where student_id=?1 and subject_id=?2");
		query.setParameter(1, studId);
		query.setParameter(2, subId);
		entityTransaction.commit();
		Marks marks = (Marks) query.getSingleResult();
		return marks;
	}

	@Override
	public List<Marks> getAllMarkByOnePerson(int studId) {
		entityTransaction.begin();
		Query query = entityManager.createQuery("select e from Marks e where student_id=?1");
		query.setParameter(1, studId);
		entityTransaction.commit();
		return query.getResultList();
	}

	@Override
	public Marks update(Marks marks) {
		Marks marks2 = entityManager.find(Marks.class, marks.getId());
		if (marks2 != null) {
			entityTransaction.begin();
			entityManager.merge(marks);
			entityTransaction.commit();
			return marks2;

		}

		return null;
	}

	@Override
	public Marks save(int studId, int subId, Marks marks) {
		Student student = entityManager.find(Student.class, studId);
		Subject subject = entityManager.find(Subject.class, subId);
		if (subject != null && student != null) {
			student.getSubjectMarks().add(marks);
			subject.getSubjectMarks().add(marks);

			marks.setStudent(student);
			marks.setSubject(subject);

			entityTransaction.begin();

			entityManager.persist(marks);

			entityTransaction.commit();

			return marks;
		}
		return null;
	}

	@Override
	public boolean delete(int studId, int subId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Marks> getBySubjectId(int subId) {
		Query query = entityManager.createQuery("select e from Marks e where subject_id=?1");
		query.setParameter(1, subId);
		return  query.getResultList();
	}

}
