package com.rcet.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rcet.dao.DepartmentDao;
import com.rcet.dto.College;
import com.rcet.dto.Department;

public class DepartmentDaoImp implements DepartmentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("minhaj");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Department save(int cid, Department department) {
		College college = entityManager.find(College.class, cid);
		if (college != null) {
			department.setCollege(college);
			college.getDepartments().add(department);
			entityTransaction.begin();
			entityManager.persist(department);
			entityTransaction.commit();

			return department;
		} else {
			return null;
		}
	}

	@Override
	public Department get(int did) {
		Department department = entityManager.find(Department.class, did);
		if (department != null) {
			return department;

		}
		return null;
	}

	@Override
	public List<Department> getAll() {
		Query query = entityManager.createQuery("select e from Department e");
		List<Department> departments = query.getResultList();
		if (departments != null) {
			return departments;
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(int did) {
		Department department = entityManager.find(Department.class, did);
		if (department != null) {
			entityTransaction.begin();
			entityManager.remove(department);
			entityTransaction.commit();
			return true;

		} else {
			return false;
		}
	}

	@Override
	public Department update(int did, Department department) {
		Department department1 = entityManager.find(Department.class, did);
		if (department1 != null) {
			department1.setDname(department.getDname());
			department1.setLocation(department.getLocation());

			entityTransaction.begin();
			entityManager.persist(department);
			entityTransaction.commit();

			return department1;

		}
		return null;
	}

	@Override
	public Department getByName(String dname) {
		Query query = entityManager.createQuery("select e from Department e where dname = ?1");
		query.setParameter(1, dname);
		return (Department) query.getSingleResult();
	}

}
