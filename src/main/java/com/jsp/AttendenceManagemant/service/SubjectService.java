package com.jsp.AttendenceManagemant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.AttendenceManagemant.dao.StudentDao;
import com.jsp.AttendenceManagemant.dto.Student;
import com.jsp.AttendenceManagemant.dto.Subject;
import com.jsp.AttendenceManagemant.exception.StudentNotFoundException;
import com.jsp.AttendenceManagemant.util.ResponseStructure;

@Service
public class SubjectService {
	@Autowired
	private StudentDao std_dao;

	public ResponseEntity<ResponseStructure<List<Subject>>> studentSubjects(int id) {
		Student subjects = std_dao.fetchByID(id);
		if (subjects != null) {
			ResponseStructure<List<Subject>> structure = new ResponseStructure<List<Subject>>();
			structure.setData(subjects.getSubjects());
			structure.setMessage("Student Subjects are");
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<List<Subject>>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> addResult(int id, int[] marks) {
		std_dao.addResult(id, marks);

		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData("Result Added");
		structure.setMessage("Result Saved");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

}
