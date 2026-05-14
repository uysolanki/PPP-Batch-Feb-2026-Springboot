package com.itp.amazon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.amazon.entity.Student;
import com.itp.amazon.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student saveStudent(Student s1) {
		return studentRepository.save(s1);
		
	}

	public Student getStudent(int studRollNo) throws RuntimeException
	{
		
		if(studentRepository.existsById(studRollNo))
		{		
		Optional<Student> optStudent=studentRepository.findById(studRollNo);	//1
		return optStudent.get();
		}
		else
			throw new RuntimeException("Student with ID "+ studRollNo+ " does not exist");
		
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
}
