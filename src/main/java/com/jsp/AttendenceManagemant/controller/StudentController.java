package com.jsp.AttendenceManagemant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.AttendenceManagemant.dto.Student;
import com.jsp.AttendenceManagemant.service.StudentService;
import com.jsp.AttendenceManagemant.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("addstudent")
	public ResponseEntity<ResponseStructure<Student>> addStudent(@RequestBody Student student, @RequestParam String class_name, String section_name){
		return service.addStudent(student,class_name,section_name);
	}
	@GetMapping("/getstudent")
	public ResponseEntity<ResponseStructure<Student>> getStudent(@RequestParam int id){
		return service.fetchStudent(id);
	}

}
