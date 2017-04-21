package com.school.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Course;
import com.school.service.SchoolService;

/**
 * @author Dimitar Kumanov
 *
 */
@RestController
@RequestMapping(value = "courses")
public class CourseController {
	
	private static final Logger log = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private SchoolService service;
	
	/**
	 * Creates a course with the given name, taught by the professor with given id
	 * 
	 * @param name the name of the course to be added
	 * @param id   the id of the professor teaching the course
	 * @return     the newly created course object
	 */
	@RequestMapping("/create")
	public Course courseCreate(@RequestParam("name") String name, @RequestParam("profID") Integer id) {
		return service.addCourse(name, id);
	}
	
	/**
	 * Finds a course by provided ID
	 * 
	 * @param id the id of the sought course
	 * @return   the course object with given id if it exists
	 */
	@RequestMapping("/find/id/{id}")
	public Course courseFindId(@PathVariable("id") Integer id) {
		return service.findCourse(id);
	}
	
	/**
	 * Finds a course by provided name
	 * 
	 * @param name the name of the sought course/s
	 * @return     the courses with the given name
	 */
	@RequestMapping("/find/name/{name}")
	public Set<Course> courseFindName(@PathVariable("name") String name) {
		return service.findCourse(name);
	}
	
	/**
	 * Deletes a course with a given id
	 * 
	 * @param id the id of the course to be removed from the database
	 * @return   the same id as the provided one
	 */
	@RequestMapping("/delete/id/{id}")
	public Integer courseDeleteId(@PathVariable("id") Integer id) {
		return service.deleteCourse(id);
	}
	
	/**
	 * Deletes all courses with the given name
	 * 
	 * @param name the name of the courses to be removed from the database
	 * @return     the list of removed courses
	 */
	@RequestMapping("/delete/name/{name}")
	public Set<Course> courseDeleteName(@PathVariable("name") String name) {
		return service.deleteCourse(name);
	}

}
