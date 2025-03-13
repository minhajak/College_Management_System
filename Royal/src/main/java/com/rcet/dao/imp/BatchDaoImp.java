package com.rcet.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rcet.dao.BatchDao;
import com.rcet.dto.Batch;
import com.rcet.dto.Department;
import com.rcet.dto.Teacher;

public class BatchDaoImp implements BatchDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("minhaj");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Batch save(int did, Batch batch) {
		Department department = entityManager.find(Department.class, did);
		if (department != null) {
			batch.setDepartment(department);
			department.getBatchs().add(batch);

			entityTransaction.begin();
			entityManager.persist(batch);
			entityManager.merge(department);
			entityTransaction.commit();
			return batch;

		}
		return null;
	}

	@Override
	public List<Batch> getAll() {
		Query query = entityManager.createQuery("select e from Batch e");
		List<Batch> batchs = query.getResultList();
		return batchs;
	}

	@Override
	public Batch get(int bid) {
		Batch batch = entityManager.find(Batch.class, bid);
		return batch;
	}

	@Override
	public Batch update(int bid, Batch batch) {
		Batch batch1 = entityManager.find(Batch.class, bid);
		if (batch1 != null) {
			batch1.setBatchCode(batch.getBatchCode());
			batch1.setLocation(batch.getLocation());
			batch1.setYear(batch.getYear());

			entityTransaction.begin();
			entityManager.merge(batch1);
			entityTransaction.commit();
			return batch1;
		}
		return null;
	}

	@Override
	public boolean delete(int bid) {
		Batch batch = entityManager.find(Batch.class, bid);
		if (batch != null) {
			entityTransaction.begin();
			entityManager.remove(batch);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public Batch get(String BatchCode) {
		Query query = entityManager.createQuery("select e from Batch e where BatchCode = ?1");
		query.setParameter(1, BatchCode);
		return (Batch) query.getSingleResult();
	}

	@Override
	public List<Batch> getByDepartmentId(int did) {
		Query query = entityManager.createQuery("select e from Batch e where department_did=?1");
		query.setParameter(1, did);
		return query.getResultList();
	}

}
