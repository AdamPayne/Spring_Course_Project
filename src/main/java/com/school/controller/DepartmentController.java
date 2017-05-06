package com.school.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Department;
import com.school.service.DepartmentService;

@RestController
@RequestMapping(value = "departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Department departmentCreate(@RequestParam("name") String name) {
		return departmentService.addDepartment(name);
	}
	
	@RequestMapping("/find/id/{id}")
	public Department departmentFindId(@PathVariable("id") Integer id) {
		return departmentService.findDepartment(id);
	}
	
	@RequestMapping("/find/name/{name}")
	public Set<Department> departmentFindName(@PathVariable("name") String name) {
		return departmentService.findDepartment(name);
	}
	
	@RequestMapping(value="/delete/id/{id}", method = RequestMethod.DELETE)
	public Integer departmentDeleteId(@PathVariable("id") Integer id) {
		return departmentService.deleteDepartment(id);
	}
	
	@RequestMapping(value="/delete/name/{name}", method = RequestMethod.DELETE)
	public Set<Department> departmentDeleteName(@PathVariable("name") String name) {
		return departmentService.deleteDepartment(name);
	}
}
