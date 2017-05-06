package com.school.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	public Department findById(Integer id);
	public Set<Department> findByName(String name);
	
	@Transactional
	public Integer deleteById(Integer id);
	
	@Transactional
	public Set<Department> deleteByName(String name);
}
