package com.jsp.AttendenceManagemant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.AttendenceManagemant.dao.AdminDao;
import com.jsp.AttendenceManagemant.dto.Admin;

import com.jsp.AttendenceManagemant.exception.AdminAccountNotFoundException;
import com.jsp.AttendenceManagemant.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;

	public ResponseEntity<ResponseStructure<Admin>> adminSave(Admin admin) {
		Admin adm = dao.save(admin);
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setMessage(" Sucessfully Registered...");
		structure.setData(adm);
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Admin>> adminlogin(String email, String password) {
		Admin admin = dao.fetchByEmail(email);
		if(admin!=null) {
			
			if (admin.getPassword().equals(password)) {
				ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
				structure.setData(admin);
				structure.setMessage("Login Sucessfull...");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
			}else {
				ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
				structure.setMessage("Worng id or password");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.NOT_FOUND);
			}
			
		}
		throw new AdminAccountNotFoundException();
	}

}
