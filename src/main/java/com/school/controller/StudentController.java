package com.school.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.SchoolApplication;
import com.school.model.Student;
import com.school.service.SchoolService;

/**
 * @author Dimitar Kumanov
 *
 */
@RestController
@RequestMapping(value = "students")
public class StudentController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private SchoolService service;
	
	
	/**
	 * Create a student with the given name
	 * 
	 * @param  name the name of the student
	 * @return the newly created student
	 */
	@RequestMapping("/create")
	public Student studentCreate(@RequestParam("name") String name) {
		return service.addStudent(name);
	}
	
	
	/**
	 * Finds a student by provided ID
	 * 
	 * @param id the id of the sought student
	 * @return   the student object with given id if it exists
	 */
	@RequestMapping("/find/id/{id}")
	public Student studentFindId(@PathVariable("id") Integer id) {
		return service.findStudent(id);
	}
	
	
	/**
	 * Finds a student by provided name
	 * 
	 * @param name the name of the sought student/s
	 * @return     the students with the given name
	 */
	@RequestMapping("/find/name/{name}")
	public Set<Student> studentFindName(@PathVariable("name") String name) {
		return service.findStudent(name);
	}
	
	/**
	 * Deletes a student with a given id
	 * 
	 * @param id the id of the student to be removed from the database
	 * @return   the same id as the provided one
	 */
	@RequestMapping("/delete/id/{id}")
	public Integer studentDeleteId(@PathVariable("id") Integer id) {
		return service.deleteStudent(id);
	}
	
	
	/**
	 * Deletes all students with the given name
	 * 
	 * @param name the name of the students to be removed from the database
	 * @return     the list of removed students
	 */
	@RequestMapping("/delete/name/{name}")
	public Set<Student> studentDeleteName(@PathVariable("name") String name) {
		return service.deleteStudent(name);
	}
}
