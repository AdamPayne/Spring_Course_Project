package com.school.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Professor;
import com.school.service.SchoolService;

/**
 * @author Dimitar Kumanov
 *
 */
@RestController
@RequestMapping(value = "professors")
public class ProfessorController {
	
	private static final Logger log = LoggerFactory.getLogger(ProfessorController.class);
	
	@Autowired
	private SchoolService service;
	
	/**
	 * Creates a professor with the given name
	 * 
	 * @param name the name of the professor
	 * @return     the newly created professor
	 */
	@RequestMapping("/create")
	public Professor professorCreate(@RequestParam("name") String name) {
		return service.addProfessor(name);
	}
	
	/**
	 * Finds a professor by provided ID
	 * 
	 * @param id the id of the sought professor
	 * @return   the professor object with given id if it exists
	 */
	@RequestMapping("/find/id/{id}")
	public Professor professorFindId(@PathVariable("id") Integer id) {
		return service.findProfessor(id);
	}
	
	/**
	 * Finds a professor by provided name
	 * 
	 * @param name the name of the sought professor/s
	 * @return     the professors with the given name
	 */
	@RequestMapping("/find/name/{name}")
	public Set<Professor> professorFindName(@PathVariable("name") String name) {
		return service.findProfessor(name);
	}
	
	/**
	 * Deletes a professor with a given id
	 * 
	 * @param id the id of the professor to be removed from the database
	 * @return   the same id as the provided one
	 */
	@RequestMapping("/delete/id/{id}")
	public Integer professorDeleteId(@PathVariable("id") Integer id) {
		return service.deleteProfessor(id);
	}
	
	/**
	 * Deletes all professors with the given name
	 * 
	 * @param name the name of the professors to be removed from the database
	 * @return     the list of removed professors
	 */
	@RequestMapping("/delete/name/{name}")
	public Set<Professor> professorDeleteName(@PathVariable("name") String name) {
		return service.deleteProfessor(name);
	}
}
