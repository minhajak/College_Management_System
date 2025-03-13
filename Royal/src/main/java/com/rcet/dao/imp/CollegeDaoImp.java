package com.rcet.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rcet.dao.CollegeDao;
import com.rcet.dto.College;

public class CollegeDaoImp implements CollegeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("minhaj");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public College save(College college) {
		entityTransaction.begin();
		entityManager.persist(college);
		entityTransaction.commit();
		return college;
	}

	@Override
	public boolean deleteById(int cid) {
		College college = entityManager.find(College.class, cid);

		if (college != null) {
			entityTransaction.begin();
			entityManager.remove(college);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public College update(int cid, College college) {
		College college1 = entityManager.find(College.class, cid);
		if (college1!=null) {
			
			college1.setName(college.getName());
			college1.setWebsite(college.getWebsite());
			
			entityTransaction.begin();
			entityManager.merge(college1);
			entityTransaction.commit();
			
			return college;
					
		}
		return null;
	}

	@Override
	public College get(int cid) {
		entityTransaction.begin();
		College college = entityManager.find(College.class, cid);
		return college;
	}
}
