package com.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "course")
public class Course {
	
	private static final Logger log = LoggerFactory.getLogger(Course.class);
	
	//properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students = new HashSet<Student>();
	
	
	@ManyToOne
	@JoinColumn(
			name = "prof_id",
			insertable = true, updatable = true,  nullable = false)
	@JsonManagedReference
	private Professor prof;
	
	// constructors
	public Course(){}
	
	public Course(String name, Professor prof){
		this.name = name;
		this.prof = prof;
	}
	
	// getters and setters
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}
}
