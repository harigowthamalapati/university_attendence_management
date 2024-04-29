package com.jsp.AttendenceManagemant.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.AttendenceManagemant.dao.AttendenceDao;
import com.jsp.AttendenceManagemant.dao.StudentDao;
import com.jsp.AttendenceManagemant.dto.Attendence;
import com.jsp.AttendenceManagemant.dto.Student;
import com.jsp.AttendenceManagemant.exception.StudentNotFoundException;
import com.jsp.AttendenceManagemant.util.ResponseStructure;

@Service
public class AttendenceService {

	@Autowired
	private AttendenceDao att_dao;

	@Autowired
	private StudentDao std_dao;

	public ResponseEntity<ResponseStructure<String>> takeAttendence(List<Integer> student_ids, LocalDate date,
			String status) {
		List<Student> std_list = new ArrayList<Student>();
		for (Integer id : student_ids) {
			Student student = std_dao.fetchByID(id);
			std_list.add(student);
		}
		Attendence attendence = new Attendence();
		attendence.setStatus(status);
		attendence.setAttendence_date(date);
		attendence.setStudent(std_list);
		att_dao.saveAttendence(attendence);

		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage("Attendence Sucessfully Taken");
		structure.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<List<Attendence>>> fetchAttendence(Integer id) {
		Student student = std_dao.fetchByID(id);
		if (student != null) {
			ResponseStructure<List<Attendence>> structure = new ResponseStructure<List<Attendence>>();
			// structure.setData();
			structure.setMessage(" Student Attendence ");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<List<Attendence>>>(structure, HttpStatus.FOUND);
		}
		throw new StudentNotFoundException();
	}

}
