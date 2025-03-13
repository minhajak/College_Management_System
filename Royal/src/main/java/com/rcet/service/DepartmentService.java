package com.rcet.service;

import java.util.List;

import com.rcet.dao.DepartmentDao;
import com.rcet.dao.imp.DepartmentDaoImp;
import com.rcet.dto.Department;

public class DepartmentService {
	DepartmentDao dao = new DepartmentDaoImp();

	public void saveDepartment(int cid, Department department) {
		Department department1 = dao.save(cid, department);
		if (department1 != null) {
			System.out.println("department data saved");
		} else {
			System.out.println("failed to save department data");
		}

	}

	public Department getDepartment(int did) {
		Department department = dao.get(did);
		if (department != null) {
			return department;
		} else {
			return null;
		}
	}

	public List<Department> getAllDepartments() {
		List<Department> departments = dao.getAll();
		if (departments != null) {
			return departments;
		} else {
			return null;
		}

	}

	public void deleteDepartment(int did) {
		boolean flag = dao.delete(did);
		if (flag) {
			System.out.println("successfully deleted department");
		} else {
			System.out.println("failed to delete department");
		}
	}

	public Department updateDepartment(int did, Department department) {
		Department department1 = dao.update(did, department);
		if (department1 != null) {
			System.out.println("department updated");
			return department1;
		} else {
			System.out.println("failed to update department ");
			return null;
		}
	}
	public Department getDepartmentByDname(String dname) {
		Department department = dao.getByName(dname);
		if (department != null) {
			return department;
		} else {
			return null;
		}
		
	}
}
