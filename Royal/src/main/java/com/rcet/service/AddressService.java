package com.rcet.service;

import com.rcet.dao.AddressDao;
import com.rcet.dao.imp.AddressDaoImp;
import com.rcet.dto.Address;

public class AddressService {
	AddressDao dao = new AddressDaoImp();

	public void saveAddress(int cid, Address address) {
		Address address1 = dao.save(cid, address);
		if (address1 != null) {
			System.out.println("address saved successfully");
		} else {
			System.out.println("failed to save address");
		}
	}

	public Address getAddress(int aid) {
		Address address = dao.get(aid);
		if (address != null) {
			System.out.println("address data retrieved");
			return address;
		} else {
			System.out.println("failed to retrieve address data");
			return null;

		}

	}

	public Address updateAddress(int aid, Address address) {
		Address address1 = dao.update(aid, address);
		if (address1 != null) {
			System.out.println("address details updated successfully");
			return address1;
		} else {
			System.out.println("failed to update address details");
			return null;
		}
	}

	public void deleteAddress(int aid) {

		boolean flag = dao.delete(aid);
		if (flag) {
			System.out.println("address details deleted successfully");
		} else {
			System.out.println("failed to delete the address details");
		}
	}

}
