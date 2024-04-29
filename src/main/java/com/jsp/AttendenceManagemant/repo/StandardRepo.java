package com.jsp.AttendenceManagemant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.AttendenceManagemant.dto.Standard;

public interface StandardRepo extends JpaRepository<Standard, Integer> {
	@Query("select s from Standard s where s.class_name=?1")
	Standard searchByName(String class_name);


}
