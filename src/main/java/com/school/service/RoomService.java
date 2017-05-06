package com.school.service;

import java.util.Set;

import com.school.model.Room;

public interface RoomService {
	
	public Room addRoom(String location);
	
	public Room findRoom(Integer id);
	
	public Set<Room> findRoom(String location);
	
	public Integer deleteRoom(Integer id);
	
	public Set<Room> deleteRoom(String location);

}
