package com.jsp.AttendenceManagemant.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.AttendenceManagemant.dto.Attendence;
import com.jsp.AttendenceManagemant.service.AttendenceService;
import com.jsp.AttendenceManagemant.util.ResponseStructure;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class AttendenceController {
	
	@Autowired
	private AttendenceService service;
	@GetMapping("/take")
	public ResponseEntity<ResponseStructure<String>> takeAttendence(@RequestParam List<Integer> student_ids, LocalDate date, String status){
		return service.takeAttendence(student_ids,date,status);
	}
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<List<Attendence>>> fetchStudentAttendence(@RequestParam Integer id){
		return service.fetchAttendence(id);
		
	}
	
	
	

}
