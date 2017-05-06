package com.school.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Room;
import com.school.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Override
	public Room addRoom(String location) {
		return roomRepo.save(new Room(location));
	}

	@Override
	public Room findRoom(Integer id) {
		return roomRepo.findById(id);
	}

	@Override
	public Set<Room> findRoom(String location) {
		return roomRepo.findByLocation(location);
	}

	@Override
	public Integer deleteRoom(Integer id) {
		return roomRepo.deleteById(id);
	}

	@Override
	public Set<Room> deleteRoom(String location) {
		return roomRepo.deleteByLocation(location);
	}

}
