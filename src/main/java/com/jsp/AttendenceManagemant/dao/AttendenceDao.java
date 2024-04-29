package com.jsp.AttendenceManagemant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.AttendenceManagemant.dto.Attendence;
import com.jsp.AttendenceManagemant.repo.AttendenceRepo;

@Repository
public class AttendenceDao {

	@Autowired
	private AttendenceRepo repo;

	public void saveAttendence(Attendence attendence) {

		repo.save(attendence);
	}

}
