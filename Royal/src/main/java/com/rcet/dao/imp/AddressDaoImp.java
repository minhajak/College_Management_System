package com.rcet.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rcet.dao.AddressDao;
import com.rcet.dto.Address;
import com.rcet.dto.College;

public class AddressDaoImp implements AddressDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("minhaj");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Address save(int cid, Address address) {
		College college = entityManager.find(College.class, cid);
		if (college != null) {
			address.setCollege(college);
			college.setAddress(address);
			entityTransaction.begin();
			entityManager.persist(address);
			entityManager.merge(college);
			entityTransaction.commit();

			return address;
		}
		return null;
	}

	@Override
	public Address update(int aid, Address address) {
		Address address1 = entityManager.find(Address.class, aid);
		if (address1 != null) {
			address1.setState(address.getState());
			address1.setDistrict(address.getDistrict());
			address1.setStreet(address.getStreet());
			address1.setPin(address.getPin());

			entityTransaction.begin();
			entityManager.merge(address1);
			return address1;
		}
		return null;
	}

	@Override
	public boolean delete(int aid) {
		Address address = entityManager.find(Address.class, aid);
		if (address != null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public Address get(int aid) {
		Address address = entityManager.find(Address.class, aid);
		return address;
	}

}
