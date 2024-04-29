package com.jsp.AttendenceManagemant.exception;

import lombok.Data;

@Data
public class StandardNotFoundException extends RuntimeException {
	
	private String msg="Standard Not Found";

}
