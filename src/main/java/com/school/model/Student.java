package com.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="student")
public class Student {
	
	private static final Logger log = LoggerFactory.getLogger(Student.class);
	
	//properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stud_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "standing", nullable = true)
	private String standing;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name="student_course",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses = new HashSet<Course>();
	
	// constructors
	public Student(){}
	
	public Student(String name){
		this.name = name;
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

	public String getStanding() {
		return standing;
	}

	public void setStanding(String standing) {
		this.standing = standing;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
