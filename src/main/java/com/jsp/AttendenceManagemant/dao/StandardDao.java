package com.jsp.AttendenceManagemant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.AttendenceManagemant.dto.Standard;
import com.jsp.AttendenceManagemant.repo.StandardRepo;

@Repository
public class StandardDao {

	@Autowired
	private StandardRepo repo;

	public List<Standard> saveClass(Standard standard) {

		repo.save(standard);
		return repo.findAll();
	}

	public Standard fetchByName(String class_name) {
		return repo.searchByName(class_name);

	}

	public List<Standard> fetchAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Standard fetchSections(String standardname) {
		return repo.searchByName(standardname);
		
	}

}
