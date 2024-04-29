package com.jsp.AttendenceManagemant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.AttendenceManagemant.dao.SectionDao;
import com.jsp.AttendenceManagemant.dao.StandardDao;
import com.jsp.AttendenceManagemant.dao.StudentDao;
import com.jsp.AttendenceManagemant.dto.Section;
import com.jsp.AttendenceManagemant.dto.Standard;
import com.jsp.AttendenceManagemant.dto.Student;
import com.jsp.AttendenceManagemant.exception.SectionNotFoundSectionException;
import com.jsp.AttendenceManagemant.exception.StandardNotFoundException;
import com.jsp.AttendenceManagemant.exception.StudentNotFoundException;
import com.jsp.AttendenceManagemant.util.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;
	@Autowired
	private StandardDao std_dao;
	@Autowired
	private SectionDao sec_dao;

	public ResponseEntity<ResponseStructure<Student>> addStudent(Student student, String class_name,
			String section_name) {
		Standard standard = std_dao.fetchByName(class_name);
		if (standard != null) {
			List<Section> sections = standard.getSections();
			Section section = sec_dao.findSection(section_name, sections);
			if (section != null) {
				List<Student> old_students = section.getStudents();
				Student dbstudent = dao.saveStudent(student);
				old_students.add(dbstudent);
				sec_dao.addSection(section);

				ResponseStructure<Student> structure = new ResponseStructure<Student>();
				structure.setData(dbstudent);
				structure.setMessage("student Added Sucessfully");
				structure.setStatus(HttpStatus.OK.value());

				return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
			}
			throw new SectionNotFoundSectionException();

		}

		throw new StandardNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Student>> fetchStudent(int id) {
		Student student = dao.fetchByID(id);
		if (student != null) {
			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setData(student);
			structure.setMessage("Student Fetched Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFoundException();
	}

}
