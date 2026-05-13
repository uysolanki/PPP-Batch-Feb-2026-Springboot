package com.itp.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itp.amazon.entity.Student;
import com.itp.amazon.service.StudentService;

import jakarta.websocket.server.PathParam;

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
	
	@RequestMapping("/saveStudentUsingRequestParam")
	public Student saveStudentUsingRequestParam(
			@RequestParam("a") String studentName,
			@RequestParam("b") String deptName,
			@RequestParam("c") double studentPer
			)
	{
		Student s1=Student.builder()
				.sname(studentName)
				.dname(deptName)
				.per(studentPer)
				.build();
		
		return studentService.saveStudent(s1);
		//return "Record Saved";
		
	}
	
	@RequestMapping("/saveStudentUsingRequestParam1")
	public Student saveStudentUsingRequestParam1(
			@RequestParam String studentName,
			@RequestParam String deptName,
			@RequestParam double studentPer
			)
	{
		Student s1=Student.builder()
				.sname(studentName)
				.dname(deptName)
				.per(studentPer)
				.build();
		
		return studentService.saveStudent(s1);
		//return "Record Saved";
		
	}
	
	
	@RequestMapping("/saveStudentUsingPathVariable/{a}/{b}/{c}")
	public Student saveStudentUsingPathVariable(
			@PathVariable("a") String studentName,
			@PathVariable("b") String deptName,
			@PathVariable("c") double studentPer
			)
	{
		Student s1=Student.builder()
				.sname(studentName)
				.dname(deptName)
				.per(studentPer)
				.build();
		
		return studentService.saveStudent(s1);
		//return "Record Saved";
		
	}
	
	@RequestMapping("/saveStudentUsingPathVariable1/{studentName}/{deptName}/{studentPer}")
	public Student saveStudentUsingPathVariable1(
			@PathVariable String studentName,
			@PathVariable String deptName,
			@PathVariable double studentPer
			)
	{
		Student s1=Student.builder()
				.sname(studentName)
				.dname(deptName)
				.per(studentPer)
				.build();
		
		return studentService.saveStudent(s1);
		//return "Record Saved";
		
	}
	
	@RequestMapping("/saveStudentUsingRequestBody")
	public Student saveStudentUsingRequestBody(@RequestBody Student s1)
	{
		return studentService.saveStudent(s1);
		
	}
	
	
	
	@RequestMapping("/getStudent")
	public Student getStudent()
	{
		int studRollNo=2;
		return studentService.getStudent(studRollNo);
		//return "Record Saved";
		
	}

}

/*
{
    "rno": 8,
    "sname": "Vedant",
    "dname": "Science",
    "per": 78.6
}
*/
