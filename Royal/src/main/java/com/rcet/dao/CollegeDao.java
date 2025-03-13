package com.rcet.dao;

import com.rcet.dto.College;

public interface CollegeDao {
	College save(College college);

	boolean deleteById(int cid);

	College update(int cid, College college);

	College get(int cid);
}
