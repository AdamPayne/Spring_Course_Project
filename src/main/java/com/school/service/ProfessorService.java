package com.school.service;

import java.util.Set;

import com.school.model.Course;
import com.school.model.Professor;

public interface ProfessorService {
	public Professor addProfessor(String name);
	
	public Professor findProfessor(Integer id);
	
	public Set<Professor> findProfessor(String name);
	
	public Integer deleteProfessor(Integer id);
	
	public Set<Professor> deleteProfessor(String name);
}
