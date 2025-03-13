package com.rcet.dao;

import com.rcet.dto.Address;


public interface AddressDao {
	Address save(int cid, Address address);

	Address update(int aid, Address address);

	boolean delete(int aid);

	Address get(int aid);

}
