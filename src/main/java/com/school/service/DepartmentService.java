package com.school.service;

import java.util.Set;

import com.school.model.Department;

public interface DepartmentService {
	public Department addDepartment(String name);
	
	public Department findDepartment(Integer id);
	
	public Set<Department> findDepartment(String name);
	
	public Integer deleteDepartment(Integer id);
	
	public Set<Department> deleteDepartment(String name);
}
