package com.rcet.dao;

import java.util.List;

import com.rcet.dto.Batch;

public interface BatchDao {

	Batch save(int did, Batch batch);

	List<Batch> getAll();

	Batch get(int bid);

	Batch get(String BatchCode);

	Batch update(int bid, Batch batch);

	boolean delete(int bid);

	List<Batch> getByDepartmentId(int did);

}
