package com.school.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Course;
import com.school.model.Professor;
import com.school.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	@Autowired
	private ProfessorRepository profRepo;
	
	@Override
	public Professor addProfessor(String name){
		return profRepo.save(new Professor(name));
	}
	
	@Override
	public Professor findProfessor(Integer id){
		return profRepo.findById(id);
	}
	
	@Override
	public Set<Professor> findProfessor(String name){
		return profRepo.findByName(name);
	}
	
	@Override
	public Integer deleteProfessor(Integer id){
		return profRepo.deleteById(id);
	}
	
	@Override
	public Set<Professor> deleteProfessor(String name){
		return profRepo.deleteByName(name);
	}

}
