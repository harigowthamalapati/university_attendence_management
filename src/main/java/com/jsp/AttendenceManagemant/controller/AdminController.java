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

import com.jsp.AttendenceManagemant.dto.Admin;
import com.jsp.AttendenceManagemant.service.AdminService;
import com.jsp.AttendenceManagemant.util.ResponseStructure;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class AdminController {
	@Autowired
	private AdminService service;
	
	@PostMapping("/adminsave")
	public ResponseEntity<ResponseStructure<Admin>> register(@RequestBody Admin admin){
	return	service.adminSave(admin);
	}
	
	@GetMapping("/adminlogin")
	public ResponseEntity<ResponseStructure<Admin>> login(@RequestParam String email, String password){
		return service.adminlogin(email,password);
	}

}
