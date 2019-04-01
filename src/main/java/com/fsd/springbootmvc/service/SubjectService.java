package com.fsd.springbootmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.fsd.springbootmvc.entity.Subject;

@Service
public interface SubjectService {
	public List<Subject> getAllSubjects();
	public String addSubject(Subject subject);
	public Subject searchSubjectByID(int id);
	public List<Subject> searchSubjectByDuration(int duration);
	public String deleteSubject(int id);
}
