package com.jsp.AttendenceManagemant.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.AttendenceManagemant.dto.Admin;
import com.jsp.AttendenceManagemant.repo.AdminRepo;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepo repo;

	public Admin save(Admin admin) {
		return repo.save(admin);

	}

	public Admin fetchById(int id) {
		return repo.fetchById(id);
		
	}

	public Admin fetchByEmail(String email) {
		return repo.fetchByEmail(email);
	}

}
