package com.rcet.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rcet.dao.BatchDao;
import com.rcet.dao.imp.BatchDaoImp;
import com.rcet.dto.Batch;

public class BatchService {

	BatchDao dao = new BatchDaoImp();

	public List<Batch> getAllBatchs() {
		List<Batch> batchs = dao.getAll();
		return batchs;

	}

	public Batch getBatch(int bid) {
		Batch batch = dao.get(bid);
		if (batch != null) {
			System.out.println("batch data retrived successfully");
			return batch;
		} else {
			System.out.println("failed to retrive batch data");
			return null;
		}
	}

	public Batch saveBactch(int did, Batch batch) {
		Batch batch1 = dao.save(did, batch);
		if (batch1 != null) {
			System.out.println("successfully saved the batch info");
			return batch1;
		} else {
			System.out.println("failed to save the batch info");
			return null;
		}
	}

	public void deleteBatch(int bid) {
		boolean flag = dao.delete(bid);
		if (flag) {
			System.out.println("successfully deleted batch");
		} else {
			System.out.println("failed to delete batch");
		}
	}

	public Batch updateBatch(int bid, Batch batch) {
		Batch batch1 = dao.update(bid, batch);
		if (batch1 != null) {
			System.out.println("batch updated");
			return batch1;
		} else {
			System.out.println("failed to update batch ");
			return null;
		}
	}

	public Batch getBatchByName(String BatchCode) {
		Batch batch = dao.get(BatchCode);
		return batch;
	}

	public List<Batch> getBatchesByDepartmentId(int did) {
		return dao.getByDepartmentId(did);

	}
}
