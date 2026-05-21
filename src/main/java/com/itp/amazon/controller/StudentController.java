package com.itp.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itp.amazon.dto.StudentDTO;
import com.itp.amazon.entity.Student;
import com.itp.amazon.exception.ResourceNotFoundException;
import com.itp.amazon.service.StudentService;

import jakarta.validation.Valid;

@RestController	//return json
//@Controller     //return html
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/test")
	public String test()
	{
		return "Virat";
	}
	
	@RequestMapping("/test1")
	public ResponseEntity<String> test1()
	{
		return new ResponseEntity<String> ("Virat",HttpStatus.OK);
	}
	
	@PostMapping("/saveStudent")
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
	
	@PostMapping("/saveStudent1")
	public ResponseEntity<Student> saveStudent1()
	{
		Student s1=Student.builder()
				.sname("Chris")
				.dname("Engg")
				.per(98.5)
				.build();
		
		return new ResponseEntity<Student>(studentService.saveStudent(s1), HttpStatus.CREATED);	
	}
	
	@PostMapping("/saveStudentUsingRequestParam")
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
	
	@PostMapping("/saveStudentUsingRequestParam1")
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
	
	@PostMapping("/saveStudentUsingRequestParam2")
	public ResponseEntity<Student> saveStudentUsingRequestParam2(
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
		
		return new ResponseEntity<Student>(studentService.saveStudent(s1), HttpStatus.CREATED);
		//return "Record Saved";
		
	}
	
	@PostMapping("/saveStudentUsingPathVariable/{a}/{b}/{c}")
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
	
	@PostMapping("/saveStudentUsingPathVariable1/{studentName}/{deptName}/{studentPer}")
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
	
	@PostMapping("/saveStudentUsingRequestBody")
	public Student saveStudentUsingRequestBody(@RequestBody Student s1)
	{
		return studentService.saveStudent(s1);
	}
	
	@PostMapping("/saveStudentUsingDTO")
	public ResponseEntity<StudentDTO> saveStudentUsingDTO(@RequestBody StudentDTO studDTO)
	{
		return new ResponseEntity<StudentDTO>(studentService.saveStudentUsingDTO(studDTO),HttpStatus.OK);
	}
	
	@PostMapping("/saveStudentUsingDTOWithValidation")
	public ResponseEntity<StudentDTO> saveStudentUsingDTOWithValidation(@Valid @RequestBody  StudentDTO studDTO)
	{
		return new ResponseEntity<StudentDTO>(studentService.saveStudentUsingDTO(studDTO),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents()			//fixed status code a= 200 fixed status message OK
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getAllStudents1")
	public ResponseEntity<List<Student>> getAllStudents1()			//fixed status code a= 200 fixed status message OK
	{
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudents2")
	public ResponseEntity<List<Student>> getAllStudents2()			//fixed status code a= 200 fixed status message OK
	{
		List<Student> studs=studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(studs,HttpStatus.OK);
	}
	
	@GetMapping("/getStudent/{rollno}")
	public ResponseEntity<?> getStudent(@PathVariable int rollno)
	{
		try
		{
		return new ResponseEntity<Student>(studentService.getStudent(rollno), HttpStatus.OK);
		}
		catch(RuntimeException ex1)
		{
		return new ResponseEntity<String>("Student with Roll Number " + rollno + " does not  Exist",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getStudent1/{rollno}")
	public ResponseEntity<?> getStudent1(@PathVariable int rollno)
	{
		try
		{
		return new ResponseEntity<Student>(studentService.getStudent1(rollno), HttpStatus.OK);
		}
		catch(ResourceNotFoundException ex1)
		{
		return new ResponseEntity<String>(ex1.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getStudent2/{rollno}")
	public ResponseEntity<Student> getStudent2(@PathVariable int rollno) //13
	{
		return new ResponseEntity<Student>(studentService.getStudent1(rollno), HttpStatus.OK);
	}

	@GetMapping("/getStudentAboveBasePercentage/{basePer}")
	public ResponseEntity<List<Student>> getStudentAboveBasePercentage(@PathVariable double basePer) //13
	{
		return new ResponseEntity<List<Student>>(studentService.getStudentAboveBasePercentage(basePer), HttpStatus.OK);
	}
	
	@GetMapping("/getStudentBetweenPercentageRange/{start}/{end}")
	public ResponseEntity<List<Student>> getStudentBetweenPercentageRange(@PathVariable double start,@PathVariable double end) //13
	{
		return new ResponseEntity<List<Student>>(studentService.getStudentBetweenPercentageRange(start,end), HttpStatus.OK);
	}
	
	@GetMapping("/getStudentByDepartment/{deptname}")
	public ResponseEntity<List<Student>> getStudentByDepartment(@PathVariable String deptname) //13
	{
		return new ResponseEntity<List<Student>>(studentService.getStudentByDepartment(deptname), HttpStatus.OK);
	}
	
	@GetMapping("/getStudentsByPage/{pageNumber}/{pageSize}")
	public ResponseEntity<Page<Student>> getStudentsByPage(@PathVariable int pageNumber, @PathVariable int pageSize)			//fixed status code a= 200 fixed status message OK
	{
		
		return new ResponseEntity<Page<Student>>(studentService.getStudentsByPage(pageNumber,pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/getStudentsByPageSorted/{fieldName}/{pageNumber}/{pageSize}")
	public ResponseEntity<Page<Student>> getStudentsByPageSorted(@PathVariable String fieldName, @PathVariable int pageNumber, @PathVariable int pageSize)			//fixed status code a= 200 fixed status message OK
	{
		return new ResponseEntity<Page<Student>>(studentService.getStudentsByPageSorted(fieldName,pageNumber,pageSize),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteStudent/{rollno}")
	public ResponseEntity<String> deleteStudent(@PathVariable int rollno)			
	{
		studentService.deleteStudent(rollno);
		return new ResponseEntity<String>("Student Record Deleted having rollno "+rollno,HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{rollno}")
	public ResponseEntity<Student> updateStudent(@PathVariable int rollno, @RequestBody Student student)			
	{
		Student updatedStudent=studentService.updateStudent(rollno,student);
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
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


/* return 1 ) directly : limitation //fixed status code a= 200 fixed status message OK
         2 ) ResponseEntity<Student>  ,ResponseEntity<List<Student>>  , ResponseEntity<String> */
