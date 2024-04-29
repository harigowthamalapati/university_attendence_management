package com.jsp.AttendenceManagemant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.AttendenceManagemant.dao.SectionDao;
import com.jsp.AttendenceManagemant.dao.StandardDao;
import com.jsp.AttendenceManagemant.dao.StudentDao;
import com.jsp.AttendenceManagemant.dao.SubjectDao;
import com.jsp.AttendenceManagemant.dto.Section;
import com.jsp.AttendenceManagemant.dto.Standard;
import com.jsp.AttendenceManagemant.dto.Student;
import com.jsp.AttendenceManagemant.dto.Subject;
import com.jsp.AttendenceManagemant.exception.SectionNotFoundSectionException;
import com.jsp.AttendenceManagemant.exception.StandardNotFoundException;
import com.jsp.AttendenceManagemant.util.ResponseStructure;

@Service
public class SectionService {

	@Autowired
	private SectionDao sec_dao;
	@Autowired
	private StandardDao std_dao;
	@Autowired
	private SubjectDao sub_dao;
	@Autowired
	private StudentDao student_dao;

	public ResponseEntity<ResponseStructure<Section>> addSection(Section section, String class_name) {
		Standard standard = std_dao.fetchByName(class_name);
		List<Section> old_sections = standard.getSections();
		if (standard != null) {
			Section dbsection = sec_dao.addSection(section);
			old_sections.add(section);
			standard.setSections(old_sections);
			std_dao.saveClass(standard);
			ResponseStructure<Section> structure = new ResponseStructure<Section>();
			structure.setData(dbsection);
			structure.setMessage("Section Added");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Section>>(structure, HttpStatus.CREATED);

		}
		throw new StandardNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchAllStudents(String class_name, String section_name) {
		Standard standard = std_dao.fetchByName(class_name);
		if (standard != null) {
			List<Section> sections = standard.getSections();
			Section section = sec_dao.fetchSection(section_name, sections);
			ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
			structure.setData(section.getStudents());
			structure.setMessage("Students in the section");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		}
		throw new SectionNotFoundSectionException();
	}

	public ResponseEntity<ResponseStructure<List<Subject>>> addSubject(String class_name, String section_name,
			Subject subject) {
		Standard standard = std_dao.fetchByName(class_name);
		if (standard != null) {
			List<Section> standard_sections = standard.getSections();
			Section section = sec_dao.findSection(section_name, standard_sections);

			if (section != null) {
				List<Student> sec_students = section.getStudents();
				for (int i = 0; i < sec_students.size(); i++) {
					Student student = sec_students.get(i);
					if (student != null) {
						Subject dbsubject = sub_dao.saveSubject(subject);

						List<Subject> studentSubjects = student.getSubjects();
						studentSubjects.add(dbsubject);
						student.setSubjects(studentSubjects);
						student_dao.saveStudent(student);

						List<Subject> sec_subjects = section.getSubjects();
						sec_subjects.add(dbsubject);
						section.setSubjects(sec_subjects);
						sec_dao.addSection(section);

					}

				}

				ResponseStructure<List<Subject>> structure = new ResponseStructure<List<Subject>>();
				structure.setData(section.getSubjects());
				structure.setMessage("Subject Added Sucessfully..");
				structure.setStatus(HttpStatus.OK.value());

				return new ResponseEntity<ResponseStructure<List<Subject>>>(structure, HttpStatus.OK);

			}
			throw new SectionNotFoundSectionException();

		}
		throw new StandardNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Subject>>> fetchSubjects(String class_name, String section_name) {
		Standard standard = std_dao.fetchByName(class_name);
		if (standard != null) {
			List<Section> standard_sections = standard.getSections();
			Section section = sec_dao.fetchSection(section_name, standard_sections);
			if (section != null) {
				ResponseStructure<List<Subject>> structure = new ResponseStructure<List<Subject>>();
				structure.setData(section.getSubjects());
				structure.setMessage("Available Subjects are");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<List<Subject>>>(structure, HttpStatus.OK);
			}
			throw new SectionNotFoundSectionException();
		}
		throw new StandardNotFoundException();

	}

}
