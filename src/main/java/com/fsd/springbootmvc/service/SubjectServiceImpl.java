package com.fsd.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.springbootmvc.dao.SubjectDao;
import com.fsd.springbootmvc.entity.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;

	@Override
	public List<Subject> getAllSubjects() {		
		return subjectDao.findAll();
	}

	@Override
	public String addSubject(Subject subject) {
		subjectDao.save(subject);
		return "subject saved successfully";
	}

	@Override
	public Subject searchSubjectByID(int id) {
		Optional<Subject> optional= subjectDao.findById(id);
		return optional.get();
	}

	@Override
	public String deleteSubject(int id) {
		subjectDao.deleteById(id);
		return "subject deleted successfully";
	}

	@Override
	public List<Subject> searchSubjectByDuration(int duration) {
		return subjectDao.findByDuration(duration);		
	}

}
