package com.rcet.dao;

import java.util.List;

import com.rcet.dto.Department;

public interface DepartmentDao {

	Department save(int cid, Department department);

	Department get(int did);

	Department getByName(String dname);

	List<Department> getAll();

	boolean delete(int did);

	Department update(int did, Department department);

}
