package com.itp.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.amazon.entity.Student;
import com.itp.amazon.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public void saveStudent(Student s1) {
		studentRepository.save(s1);
		
	}
}
