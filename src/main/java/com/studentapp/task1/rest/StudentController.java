package com.studentapp.task1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.task1.entity.Student;
import com.studentapp.task1.service.StudentService;

@RestController
@RequestMapping("/task1")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService theStudentService) {
		
		studentService = theStudentService;
		
	}
	
	@GetMapping("/students")
	public List<Student> findAll(){
		return studentService.getStudentList();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		Student theEmployee = studentService.getStudent(studentId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Student id not found - " + studentId);
		}
		
		return theEmployee;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student theStudent) {
		
		studentService.save(theStudent);
		
		return theStudent;
	}
	
	
	@DeleteMapping("/students/{studentId}")
	public String deleteEmployee(@PathVariable int studentId) {
		
		Student tempStudent = studentService.getStudent(studentId);
		
		// throw exception if null
		
		if (tempStudent == null) {
			throw new RuntimeException("Employee id not found - " + studentId);
		}
		
		studentService.delete(studentId);
		
		return "Deleted student id - " + studentId;
	}
}
