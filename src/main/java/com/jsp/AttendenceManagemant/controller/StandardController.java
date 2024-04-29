package com.jsp.AttendenceManagemant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.AttendenceManagemant.dto.Section;
import com.jsp.AttendenceManagemant.dto.Standard;
import com.jsp.AttendenceManagemant.service.StandardService;
import com.jsp.AttendenceManagemant.util.ResponseStructure;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class StandardController {
	@Autowired
	private StandardService service;

	@PostMapping("/addclass")
	public ResponseEntity<ResponseStructure<List<Standard>>> addClass(@RequestBody Standard standard) {

		return service.addClass(standard);

	}
	@GetMapping("/fetchallclasses")
	public ResponseEntity<ResponseStructure<List<Standard>>> fetchAll(){
		return service.fetchAll();
		
	}
	@GetMapping("/fetchsections")
	public ResponseEntity<ResponseStructure<List<Section>>> fetchSections(@RequestParam String standardname){
		return service.fetchSections(standardname);
	}
}
