package com.jsp.AttendenceManagemant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.AttendenceManagemant.dto.Subject;
import com.jsp.AttendenceManagemant.repo.SubjectRepo;

@Repository
public class SubjectDao {
	@Autowired
	private SubjectRepo repo;

	public Subject saveSubject(Subject subject) {
		return repo.save(subject);
		
	}
	

}
