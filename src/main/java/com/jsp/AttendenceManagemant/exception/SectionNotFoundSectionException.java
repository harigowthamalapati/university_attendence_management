package com.jsp.AttendenceManagemant.exception;

import lombok.Data;

@Data
public class SectionNotFoundSectionException extends RuntimeException{

	private String msg =" Section Not Found";
}
