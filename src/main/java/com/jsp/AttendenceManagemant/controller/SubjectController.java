package com.jsp.AttendenceManagemant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.AttendenceManagemant.dao.StudentDao;
import com.jsp.AttendenceManagemant.dto.Student;
import com.jsp.AttendenceManagemant.dto.Subject;
import com.jsp.AttendenceManagemant.service.SubjectService;
import com.jsp.AttendenceManagemant.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class SubjectController {

	@Autowired
	private SubjectService service;

	@GetMapping("/studentsubjects")
	public ResponseEntity<ResponseStructure<List<Subject>>> studentSubjects(@RequestParam int id) {
		return service.studentSubjects(id);
	}
	
	@GetMapping("/addresult")
	public ResponseEntity<ResponseStructure<String>> addResult(@RequestParam int id, int [] marks){
		return service.addResult(id,marks);
	}

}
