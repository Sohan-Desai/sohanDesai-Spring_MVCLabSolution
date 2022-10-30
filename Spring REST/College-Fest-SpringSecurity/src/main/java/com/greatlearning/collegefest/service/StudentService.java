package com.greatlearning.collegefest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.collegefest.model.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(long id);
	
	public void saveStudent(Student theStudent);
	
	public Student updateStudent(Student theStudent);
	
	public void deleteById(long theId);
}
