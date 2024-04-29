package com.jsp.AttendenceManagemant.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.AttendenceManagemant.dto.Student;
import com.jsp.AttendenceManagemant.dto.Subject;

public interface StudentRepo extends JpaRepository<Student, Integer>{


}
