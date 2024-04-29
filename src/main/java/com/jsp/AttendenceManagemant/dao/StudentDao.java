package com.jsp.AttendenceManagemant.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.AttendenceManagemant.dto.Student;
import com.jsp.AttendenceManagemant.dto.Subject;
import com.jsp.AttendenceManagemant.repo.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo repo;

	public Student saveStudent(Student student) {

		return repo.save(student);
	}

	public Student fetchByID(Integer student) {
		return repo.findById(student).get();

	}

	public void addResult(int id, int[] marks) {
		Student student = repo.findById(id).get();
		if (student != null) {
			List<Subject> subjects = student.getSubjects();
			for (int i = 0; i < subjects.size(); i++) {

				subjects.get(i).setScored_marks(marks[i]);
			}
		}
		repo.save(student);

	}

}
