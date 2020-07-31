package com.studentapp.task1.service;

import java.util.List;

import com.studentapp.task1.entity.Student;

public interface StudentService {

	public List<Student> getStudentList();
	
	public Student getStudent(int Id);
	
	public void save(Student theStudent);
	
	public void delete(int Id);
}
