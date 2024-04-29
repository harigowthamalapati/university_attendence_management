package com.jsp.AttendenceManagemant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.AttendenceManagemant.dto.Attendence;

public interface AttendenceRepo extends JpaRepository<Attendence, Integer>{

}
