package com.jsp.AttendenceManagemant.exception;

import lombok.Data;

@Data
public class AdminAccountNotFoundException extends RuntimeException {
	
	private String msg="No Admin Found";

}
