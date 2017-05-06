package com.school.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	public Room findById(Integer id);
	public Set<Room> findByLocation(String location);
	
	@Transactional
	public Integer deleteById(Integer id);
	
	@Transactional
	public Set<Room> deleteByLocation(String location);
}
