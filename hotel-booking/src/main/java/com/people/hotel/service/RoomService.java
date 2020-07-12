package com.people.hotel.service;

import java.util.List;

import com.people.hotel.dto.BookingDetails;
import com.people.hotel.dto.Room;
import com.people.hotel.dto.RoomBookingReqDto;

public interface RoomService {
	
	public void addRoom(Room room) throws Exception;
	public BookingDetails bookRoom(RoomBookingReqDto roomBookingDetails) throws Exception;
	public List<Room> getRoomsList();
	public List<BookingDetails> getBookingDetails();

}
