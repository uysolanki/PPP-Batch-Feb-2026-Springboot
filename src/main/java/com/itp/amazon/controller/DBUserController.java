package com.itp.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itp.amazon.entity.DBUser;
import com.itp.amazon.entity.Role;
import com.itp.amazon.repository.RoleRepository;
import com.itp.amazon.service.DBUserService;

@Controller
public class DBUserController {

	@Autowired
	DBUserService dbUserService;
	
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping("/saveUserForm")
	public String saveUserForm(Model model)
	{
		DBUser user=new DBUser();
		
		List<Role> roles=roleRepository.findAll();
		
		model.addAttribute("user",user);
		model.addAttribute("roles",roles);
		return "save-user-form";
	}
	
	@PostMapping("/saveUserFE")
	public String saveUserFE(@ModelAttribute DBUser user)
	{
		dbUserService.saveUser(user);
		return "redirect:/getAllStudentsFE";
	}
}
