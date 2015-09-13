package com.github.elizabetht.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.elizabetht.controller.StudentController;
import com.github.elizabetht.model.Student;
import com.github.elizabetht.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	final static Logger logger = Logger.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public boolean findByLogin(String userName, String password) {	
		Student stud = studentRepository.findByUserName(userName);
		
		if(stud != null && stud.getPassword().equals(password)) {
			
			if(logger.isDebugEnabled()){
				logger.debug("Inside the findByLogin : " + userName);
			}
			return true;
		} 
		logger.error("Oops Login failed for user : " + userName);
		return false;		
	}

	public boolean findByUserName(String userName) {
		if(logger.isDebugEnabled()){
			logger.debug("Inside the findByUserName : " + userName);
		}
		Student stud = studentRepository.findByUserName(userName);
		
		if(stud != null) {
			return true;
		}
		
		return false;
	}

}
