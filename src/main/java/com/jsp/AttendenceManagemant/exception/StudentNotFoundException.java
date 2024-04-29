package com.jsp.AttendenceManagemant.exception;

import lombok.Data;

@Data
public class StudentNotFoundException extends RuntimeException{

	private String msg="No Student Found";
}
