package com.people.hotel.dao;

import java.util.Date;
import java.util.List;

import com.people.hotel.dto.BookingDetails;
import com.people.hotel.dto.Customer;
import com.people.hotel.dto.Room;

public interface HotelManagementDao {
	
	public List<Room> getRoomsList();
	public List<BookingDetails> getBookingList();
	public Customer getCustomer(String email, String password);
	public boolean isCustomerExists(String email);
	public boolean isCustomerExists(long id);
	public Customer getCustomer(long id);
	public Room getRoom(long id);
	public boolean isRoomAvailable(long roomId, Date startDate, Date endDate);
	public void saveOrUpdate(Customer customer);
	public void saveOrUpdate(Room room);
	public void saveOrUpdateRoomBooking(BookingDetails bookDetails);

}
