package com.school.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Department;
import com.school.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository depRepo;
	
	@Override
	public Department addDepartment(String name) {
		return depRepo.save(new Department(name));
	}

	@Override
	public Department findDepartment(Integer id) {
		return depRepo.findById(id);
	}

	@Override
	public Set<Department> findDepartment(String name) {
		return depRepo.findByName(name);
	}

	@Override
	public Integer deleteDepartment(Integer id) {
		return depRepo.deleteById(id);
	}

	@Override
	public Set<Department> deleteDepartment(String name) {
		return depRepo.deleteByName(name);
	}

}
