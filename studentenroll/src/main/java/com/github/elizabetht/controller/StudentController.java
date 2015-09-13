package com.github.elizabetht.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.elizabetht.model.Student;
import com.github.elizabetht.model.StudentLogin;
import com.github.elizabetht.service.AESCrypt;
import com.github.elizabetht.service.StudentService;

@Controller
@SessionAttributes("student")
public class StudentController {
	
	final static Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private AESCrypt  aesCrypt;
	
		
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		if(logger.isDebugEnabled()){
			logger.debug("Inside the signup(model) method: " + model.toString());
		}
		Student student = new Student();		
		model.addAttribute("student", student);		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if(logger.isDebugEnabled()){
			logger.debug("Inside the signup method post : " + student.toString());
		}
		if(result.hasErrors()) {
			return "signup";
		} else if(studentService.findByUserName(student.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			
			try {
				student.setPassword(aesCrypt.encrypt(student.getPassword()) );
			} catch (Exception e) {
				logger.error("Error in setting encrypted password : ",e);
			}
			studentService.save(student);
			model.addAttribute("message", "Saved student details");
			return "redirect:login.html";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {			
		StudentLogin studentLogin = new StudentLogin();		
		model.addAttribute("studentLogin", studentLogin);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("studentLogin") StudentLogin studentLogin, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		} else {
			try {
				studentLogin.setPassword(aesCrypt.encrypt(studentLogin.getPassword()) );
			} catch (Exception e) {
				logger.error("Error in setting encrypted password : ",e);
			}
			boolean found = studentService.findByLogin(studentLogin.getUserName(), studentLogin.getPassword());
			if (found) {				
				return "success";
			} else {				
				return "failure";
			}
		}
		
	}
}
