package com.itp.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.amazon.entity.Student;
import com.itp.amazon.service.StudentService;

@RestController	//return json
//@Controller     //return html
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/saveStudent")
	public Student saveStudent()
	{
		Student s1=Student.builder()
				.sname("Chris")
				.dname("Engg")
				.per(98.5)
				.build();
		
		return studentService.saveStudent(s1);
		//return "Record Saved";
		
	}
	
	
	@RequestMapping("/getStudent")
	public Student getStudent()
	{
		int studRollNo=2;
		return studentService.getStudent(studRollNo);
		//return "Record Saved";
		
	}

}
