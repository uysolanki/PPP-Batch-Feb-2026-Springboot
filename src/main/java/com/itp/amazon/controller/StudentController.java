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
	public String saveStudent()
	{
		Student s1=Student.builder()
				.sname("Ben")
				.dname("Commerce")
				.per(68.5)
				.build();
		
		studentService.saveStudent(s1);
		return "Record Saved";
		
	}

}
