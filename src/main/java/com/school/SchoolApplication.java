package com.school;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Course;
import com.school.model.Professor;
import com.school.model.Student;
import com.school.service.SchoolService;

@EntityScan(basePackages = "com.school.model")
@EnableJpaRepositories(basePackages="com.school.repository")
@SpringBootApplication
@RestController
public class SchoolApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SchoolApplication.class);
	
	@Autowired
	private SchoolService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
	
	@RequestMapping("/students/create")
	public Student studentCreate(@RequestParam("name") String name) {
		return service.addStudent(name);
	}
	
	@RequestMapping("/professors/create")
	public Professor professorCreate(@RequestParam("name") String name) {
		return service.addProfessor(name);
	}
	
	@RequestMapping("/courses/create")
	public Course courseCreate(@RequestParam("name") String name, @RequestParam("profID") Integer id) {
		return service.addCourse(name, id);
	}
	
	@RequestMapping("/students/find/id/{id}")
	public Student studentFindId(@PathVariable("id") Integer id) {
		return service.findStudent(id);
	}
	
	@RequestMapping("/students/find/name/{name}")
	public Set<Student> studentFindName(@PathVariable("name") String name) {
		return service.findStudent(name);
	}
	
	@RequestMapping("/students/delete/id/{id}")
	public Integer studentDeleteId(@PathVariable("id") Integer id) {
		return service.deleteStudent(id);
	}
	
	@RequestMapping("/students/delete/name/{name}")
	public Set<Student> studentDeleteName(@PathVariable("name") String name) {
		return service.deleteStudent(name);
	}
	
	@RequestMapping("/professors/find/id/{id}")
	public Professor professorFindId(@PathVariable("id") Integer id) {
		return service.findProfessor(id);
	}
	
	@RequestMapping("/professors/find/name/{name}")
	public Set<Professor> professorFindName(@PathVariable("name") String name) {
		return service.findProfessor(name);
	}
	
	@RequestMapping("/professors/delete/id/{id}")
	public Integer professorDeleteId(@PathVariable("id") Integer id) {
		return service.deleteProfessor(id);
	}
	
	@RequestMapping("/professors/delete/name/{name}")
	public Set<Professor> professorDeleteName(@PathVariable("name") String name) {
		return service.deleteProfessor(name);
	}
}
