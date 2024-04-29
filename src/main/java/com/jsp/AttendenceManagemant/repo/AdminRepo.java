package com.jsp.AttendenceManagemant.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.AttendenceManagemant.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	@Query("select a from Admin a where a.id=?1")
	Admin fetchById(int id);
	@Query("select a from Admin a where a.email=?1")
	Admin fetchByEmail(String email);

}
