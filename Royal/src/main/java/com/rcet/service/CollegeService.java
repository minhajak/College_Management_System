package com.rcet.service;

import com.rcet.dao.CollegeDao;
import com.rcet.dao.imp.CollegeDaoImp;
import com.rcet.dto.College;

public class CollegeService {
	CollegeDao dao = new CollegeDaoImp();

	public void saveCollege(College college) {
		College college1 = dao.save(college);
		if (college1 != null) {
			System.out.println("college details saved successfully");
		} else {
			System.out.println("failed details to save college");
		}

	}

	public College getCollege(int cid) {
		College college = dao.get(cid);
		if (college != null) {
			System.out.println("college data retrieval successfull");
			return college;
		} else {
			System.out.println("college data retrieval failed");
			return null;
		}
	}
	public void deleteCollege(int cid) {
		boolean flag = dao.deleteById(cid);
		if (flag) {
			System.out.println("college deleted successfully");
		}
		else {
			System.out.println("failed to delete college data");
		}
	}

}
