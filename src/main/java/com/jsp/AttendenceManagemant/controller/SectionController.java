package com.jsp.AttendenceManagemant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.AttendenceManagemant.dto.Section;
import com.jsp.AttendenceManagemant.dto.Student;
import com.jsp.AttendenceManagemant.dto.Subject;
import com.jsp.AttendenceManagemant.service.SectionService;
import com.jsp.AttendenceManagemant.util.ResponseStructure;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@Controller
public class SectionController {
	
	@Autowired
	private SectionService service;
	
	@PostMapping("/addsection")
	public  ResponseEntity<ResponseStructure<Section>> addSection(@RequestBody Section section , @RequestParam String class_name){
		return service.addSection(section,class_name);
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchAllStudents(@RequestParam String class_name, String section_name){
		return service.fetchAllStudents(class_name,section_name);
	}
	
	
	@PostMapping("/addsubject")
	public ResponseEntity<ResponseStructure<List<Subject>>> addSubject(@RequestParam String class_name, String section_name, @RequestBody Subject subject ){
		return service.addSubject(class_name,section_name,subject);
	}
	
	@GetMapping("/fetchsubjects")
	public ResponseEntity<ResponseStructure<List<Subject>>> fetchSubjects(@RequestParam String class_name, String section_name){
		return service.fetchSubjects(class_name,section_name);
	}

}
