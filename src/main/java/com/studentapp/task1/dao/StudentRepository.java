package com.studentapp.task1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentapp.task1.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
