package com.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="professor")
public class Professor {
	private static final Logger log = LoggerFactory.getLogger(Professor.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prof_id", unique = true, nullable = false)
	protected Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany
	@JoinColumn(
			name = "prof_id",
			nullable = false)
	@OrderColumn(
			name = "prof_id",
			nullable = false)
	protected Set<Course> courses = new HashSet<Course>();
	
	public Professor(){}
	
	public Professor(String name){
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}