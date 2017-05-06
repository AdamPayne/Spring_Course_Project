package com.school.service;

import java.util.Set;

import com.school.model.Course;
import com.school.model.Professor;

public interface CourseService {
	public Course addCourse(String name, Integer profId);
	
	public Course findCourse(Integer id);
	
	public Set<Course> findCourse(String name);
	
	public Integer deleteCourse(Integer id);
	
	public Set<Course> deleteCourse(String name);
}
