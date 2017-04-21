package com.school.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Course;
import com.school.model.Professor;
import com.school.model.Student;
import com.school.repository.CourseRepository;
import com.school.repository.ProfessorRepository;
import com.school.repository.StudentRepository;

@Service
public class SchoolService {
	private static final Logger log = LoggerFactory.getLogger(SchoolService.class);
	
	@Autowired
	private StudentRepository studRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private ProfessorRepository profRepo;
	
	public Student addStudent(String name){
		return studRepo.save(new Student(name));
	}
	
	public Professor addProfessor(String name){
		return profRepo.save(new Professor(name));
	}
	
	public Course addCourse(String name, Integer profId){
		Professor prof = profRepo.findById(profId);
		return courseRepo.save(new Course(name, prof));
	}
	
	public Student findStudent(Integer id){
		return studRepo.findById(id);
	}
	
	public Set<Student> findStudent(String name){
		return studRepo.findByName(name);
	}
	
	public Integer deleteStudent(Integer id){
		return studRepo.deleteById(id);
	}
	
	public Set<Student> deleteStudent(String name){
		return studRepo.deleteByName(name);
	}
	
	public Professor findProfessor(Integer id){
		return profRepo.findById(id);
	}
	
	public Set<Professor> findProfessor(String name){
		return profRepo.findByName(name);
	}
	
	public Integer deleteProfessor(Integer id){
		return profRepo.deleteById(id);
	}
	
	public Set<Professor> deleteProfessor(String name){
		return profRepo.deleteByName(name);
	}
	
	public Course findCourse(Integer id){
		return courseRepo.findById(id);
	}
	
	public Set<Course> findCourse(String name){
		return courseRepo.findByName(name);
	}
	
	public Integer deleteCourse(Integer id){
		return courseRepo.deleteById(id);
	}
	
	public Set<Course> deleteCourse(String name){
		return courseRepo.deleteByName(name);
	}
}
