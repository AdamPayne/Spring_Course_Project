package com.school.repository;

import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.school.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
	public Professor findById(Integer id);
	public Set<Professor> findByName(String name);
	
	@Transactional
	public Integer deleteById(Integer id);
	
	@Transactional
	public Set<Professor> deleteByName(String name);
}
