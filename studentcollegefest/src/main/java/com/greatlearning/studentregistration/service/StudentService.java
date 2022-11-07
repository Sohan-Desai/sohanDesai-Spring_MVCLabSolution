package com.greatlearning.studentregistration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.studentregistration.entity.Student;

@Service
public interface StudentService {

	List<Student> findAll();

	Student findById(int id);

	void save(Student student3);

	void deleteById(int id);

}
