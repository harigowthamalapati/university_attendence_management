package com.jsp.AttendenceManagemant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.AttendenceManagemant.dao.SectionDao;
import com.jsp.AttendenceManagemant.dao.StandardDao;
import com.jsp.AttendenceManagemant.dto.Section;
import com.jsp.AttendenceManagemant.dto.Standard;
import com.jsp.AttendenceManagemant.util.ResponseStructure;

@Service
public class StandardService {

	@Autowired
	private StandardDao std_dao;

	@Autowired
	private SectionDao sec_dao;

	public ResponseEntity<ResponseStructure<List<Standard>>> addClass(Standard standard) {
		List<Standard> dbstandard = std_dao.saveClass(standard);
		ResponseStructure<List<Standard>> structure = new ResponseStructure<List<Standard>>();
		structure.setData(dbstandard);
		structure.setMessage("Class Added");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Standard>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Standard>>> fetchAll() {
		List<Standard> standars = std_dao.fetchAll();
		ResponseStructure<List<Standard>> structure = new ResponseStructure<List<Standard>>();
		structure.setData(standars);
		structure.setMessage("All Classes");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Standard>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Section>>> fetchSections(String standardname) {
		Standard standerd = std_dao.fetchSections(standardname);
		ResponseStructure<List<Section>> structure = new ResponseStructure<List<Section>>();
		structure.setData(standerd.getSections());
		structure.setMessage("Sections Are");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Section>>>(structure,HttpStatus.OK);
	}

}
