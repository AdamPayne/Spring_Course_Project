package com.school.service;

import java.util.Set;

import com.school.model.Student;

public interface StudentService {
	public Student addStudent(String name);
	
	public Student findStudent(Integer id);
	
	public Set<Student> findStudent(String name);
	
	public Integer deleteStudent(Integer id);
	
	public Set<Student> deleteStudent(String name);
}
