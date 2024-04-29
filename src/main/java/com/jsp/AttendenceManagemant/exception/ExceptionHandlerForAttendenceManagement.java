package com.jsp.AttendenceManagemant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.AttendenceManagemant.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandlerForAttendenceManagement {
	@ExceptionHandler(AdminAccountNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> adminNotFound(AdminAccountNotFoundException e) {

		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage("Account Not Found Exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StandardNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> standardNotFound(StandardNotFoundException e){
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage("Standard Not Found Exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(SectionNotFoundSectionException.class)
	public ResponseEntity<ResponseStructure<String>> sectionNotFoundException(SectionNotFoundSectionException e){
	
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage("Section Not Found Exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> studentNotFound(StudentNotFoundException e){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage("Student Not Found Exception");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
