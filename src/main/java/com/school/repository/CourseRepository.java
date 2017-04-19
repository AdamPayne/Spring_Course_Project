package com.school.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public Course findById(Integer id);
	public Set<Course> findByName(String name);
	
}
