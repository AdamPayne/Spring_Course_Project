package com.school.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Course;
import com.school.model.Professor;
import com.school.repository.CourseRepository;
import com.school.repository.ProfessorRepository;

@Service
public class CourseServiceImpl implements CourseService {
	private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private ProfessorRepository profRepo;
	
	@Override
	public Course addCourse(String name, Integer profId){
		Professor prof = profRepo.findById(profId);
		Course course = new Course(name, prof);
		courseRepo.save(course);
		return course;
	}
	
	@Override
	public Course findCourse(Integer id){
		return courseRepo.findById(id);
	}
	
	@Override
	public Set<Course> findCourse(String name){
		return courseRepo.findByName(name);
	}
	
	@Override
	public Integer deleteCourse(Integer id){
		return courseRepo.deleteById(id);
	}
	
	@Override
	public Set<Course> deleteCourse(String name){
		return courseRepo.deleteByName(name);
	}

}
