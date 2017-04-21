package com.school.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public Student findById(Integer id);
	public Set<Student> findByName(String name);
	
	@Transactional
	public Integer deleteById(Integer id);
	
	@Transactional
	public Set<Student> deleteByName(String name);
}
