package com.studentapp.task1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.task1.dao.StudentRepository;
import com.studentapp.task1.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository ) {
		
		studentRepository = theStudentRepository;
	}
	
	@Override
	public List<Student> getStudentList() {
		 
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(int Id) {
		Optional<Student> result = studentRepository.findById(Id);
		
		Student theStudent = null;
		
		if (result.isPresent()) {
			theStudent = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find student id - " +Id);
		}
		
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		 studentRepository.save(theStudent);
		
	}

	@Override
	public void delete(int Id) {
		studentRepository.deleteById(Id);
		
	}

	
	 

	
}
