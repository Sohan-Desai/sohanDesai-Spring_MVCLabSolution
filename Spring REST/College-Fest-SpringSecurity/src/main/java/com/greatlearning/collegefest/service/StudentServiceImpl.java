package com.greatlearning.collegefest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.collegefest.model.Student;
import com.greatlearning.collegefest.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {

		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(long id) {

		return studentRepository.findById(id).get();
	}

	@Override
	public void saveStudent(Student theStudent) {
		studentRepository.saveAndFlush(theStudent);
	}

	@Override
	public Student updateStudent(Student theStudent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long theId) {
		studentRepository.deleteById(theId);
	}

}
