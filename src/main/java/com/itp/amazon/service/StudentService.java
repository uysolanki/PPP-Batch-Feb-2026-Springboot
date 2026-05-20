package com.itp.amazon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itp.amazon.entity.Student;
import com.itp.amazon.exception.ResourceNotFoundException;
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

	public Student getStudent1(int rollno) throws ResourceNotFoundException
	{
		if(studentRepository.existsById(rollno))
		{
			Optional<Student> optStudent=studentRepository.findById(rollno);	
			return optStudent.get();
		}
		throw new ResourceNotFoundException("Student with roll number "+ rollno + " does not exist");
	}

	public List<Student> getStudentAboveBasePercentage(double basePer) {
//		return studentRepository.getStudentsByPer(basePer);   //using nativeQuery
		return studentRepository.findByPerGreaterThan(basePer);
	}

	public List<Student> getStudentByDepartment(String deptname) {
		//return studentRepository.getStudentsByDeptname(deptname);  //using nativeQuery
		return studentRepository.findByDname(deptname);
	}

	public List<Student> getStudentBetweenPercentageRange(double start, double end) {
		return studentRepository.findByPerBetween(start, end);
	}

	public Page<Student> getStudentsByPage(int pageNumber, int pageSize) {
		return studentRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}

	public Page<Student> getStudentsByPageSorted(String fieldName, int pageNumber, int pageSize) {
		return studentRepository.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC,fieldName)));
	}
}
