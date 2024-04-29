package com.jsp.AttendenceManagemant.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.AttendenceManagemant.dto.Section;
import com.jsp.AttendenceManagemant.repo.SectionRepo;

@Repository
public class SectionDao {

	@Autowired
	private SectionRepo repo;

	public Section addSection(Section section) {
		return repo.save(section);

	}

	public Section findSection(String section_name, List<Section> sections) {

		Iterator<Section> itr = sections.iterator();

		while (itr.hasNext()) {
			Section section = itr.next();
			if (section.getName().equals(section_name)) {
				return section;
			}
		}
		return null;

	}

	public Section fetchSection(String section_name, List<Section> sections) {
		Iterator<Section> itr = sections.iterator();

		while (itr.hasNext()) {
			Section section = itr.next();
			if (section.getName().equalsIgnoreCase(section_name)) {
				return section;
			}
		}
		return null;
		
	}

}
