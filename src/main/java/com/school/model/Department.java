package com.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="department")
public class Department {
	
	private static final Logger log = LoggerFactory.getLogger(Department.class);
	
	//properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dep_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy="dep", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@OrderColumn(
			name = "dep_id",
			nullable = false)
	@JsonBackReference
	private Set<Professor> professors = new HashSet<Professor>();
	
	// constructors
	public Department(){}
	
	public Department(String name){
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

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}
}
