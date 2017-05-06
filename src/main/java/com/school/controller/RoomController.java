package com.school.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Room;
import com.school.service.RoomService;

@RestController
@RequestMapping(value = "rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Room departmentCreate(@RequestParam("location") String location) {
		return roomService.addRoom(location);
	}
	
	@RequestMapping("/find/id/{id}")
	public Room departmentFindId(@PathVariable("id") Integer id) {
		return roomService.findRoom(id);
	}
	
	@RequestMapping("/find/location/{location}")
	public Set<Room> departmentFindName(@PathVariable("location") String location) {
		return roomService.findRoom(location);
	}
	
	@RequestMapping(value="/delete/id/{id}", method = RequestMethod.DELETE)
	public Integer departmentDeleteId(@PathVariable("id") Integer id) {
		return roomService.deleteRoom(id);
	}
	
	@RequestMapping(value="/delete/location/{location}", method = RequestMethod.DELETE)
	public Set<Room> departmentDeleteName(@PathVariable("location") String location) {
		return roomService.deleteRoom(location);
	}
}
