package com.itp.amazon.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itp.amazon.entity.Student;
import com.itp.amazon.service.StudentService;


@Controller     
public class StudentControllerFE {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/home")
	public String homepage()
	{
		return "landingpage";
	}
	
	@RequestMapping("/getAllStudentsFE")
	public String getAllStudentsFE(Model model)
	{
		List<Student> students=studentService.getAllStudents();
		model.addAttribute("students",students);
		return "show-students";
	}
	
	
	@RequestMapping("/saveStudentForm")
	public String saveStudentForm(Model model)
	{
		Student student=new Student();
		
		model.addAttribute("student",student);
		return "save-student-form";
	}
	
	@PostMapping("/saveStudentFE")
	public String saveStudentFE(@ModelAttribute Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/getAllStudentsFE";
	}
	
	@RequestMapping("/deleteStudentFE/{rollno}")
	public String deleteStudent(@PathVariable int rollno)			
	{
		studentService.deleteStudent(rollno);
		return "redirect:/getAllStudentsFE";
	}
	
	@RequestMapping("/updateStudentForm/{rollno}")
	public String updateStudentForm(@PathVariable int rollno, Model model)
	{
		Student student=studentService.getStudent(rollno);
		
		model.addAttribute("student",student);
		return "update-student-form";
	}
	
	@PostMapping("/updateStudentFE/{rollno}")
	public String updateStudentFE(@PathVariable int rollno,@ModelAttribute Student newValues)
	{
		studentService.updateStudent(rollno,newValues);
		return "redirect:/getAllStudentsFE";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user)  //currently logged in user is called Principal
	{

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			    "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

	
}