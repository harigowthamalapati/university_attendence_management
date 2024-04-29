package com.jsp.AttendenceManagemant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.AttendenceManagemant.dto.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
