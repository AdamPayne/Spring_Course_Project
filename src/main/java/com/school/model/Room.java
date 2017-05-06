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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="room")
public class Room {
	
	private static final Logger log = LoggerFactory.getLogger(Room.class);
	
	//properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "number", nullable = true)
	private int number;
	
	@OneToMany(mappedBy="room", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@OrderColumn(
			name = "room_id",
			nullable = false)
	@JsonBackReference
	private Set<Course> courses = new HashSet<Course>();
	
	//constructors
	public Room(){}
	
	public Room(String location){
		this.location = location;
	}

	//getters and setters
	public Integer getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
