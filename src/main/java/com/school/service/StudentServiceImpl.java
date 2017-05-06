package com.school.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Student;
import com.school.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studRepo;
	
	@Override
	public Student addStudent(String name){
		return studRepo.save(new Student(name));
	}
	
	@Override
	public Student findStudent(Integer id){
		return studRepo.findById(id);
	}
	
	@Override
	public Set<Student> findStudent(String name){
		return studRepo.findByName(name);
	}
	
	@Override
	public Integer deleteStudent(Integer id){
		return studRepo.deleteById(id);
	}
	
	@Override
	public Set<Student> deleteStudent(String name){
		return studRepo.deleteByName(name);
	}

}
