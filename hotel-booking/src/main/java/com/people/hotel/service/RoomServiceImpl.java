package com.people.hotel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people.hotel.dao.HotelManagementDao;
import com.people.hotel.dto.BookingDetails;
import com.people.hotel.dto.Customer;
import com.people.hotel.dto.Room;
import com.people.hotel.dto.RoomBookingReqDto;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	HotelManagementDao applicationDao;
	
	@Autowired
	CustomerService customerService;

//	public Customer addCustomer(Customer customer) throws Exception{
////		boolean isCreated = false;
//		int passWordLength = customer.getPassword().length();
//		
//		if(passWordLength < 8 || passWordLength > 10) {
//			throw new RuntimeException("password length should between 8 to 10 characters..");
//		}
//		
//		boolean isExists = applicationDao.isCustomerExists(customer.getEmail());
//		if(isExists) {
//			throw new RuntimeException("Customer with email is already Exists..");
//		}
//		applicationDao.saveOrUpdate(customer);
//		return customer;
//	}
	
	public void addRoom(Room room) throws Exception{
		applicationDao.saveOrUpdate(room);
	}
	
//	public boolean isCustomerExists(String email) {
//		return applicationDao.isCustomerExists(email);
//	}

//	public long getCustomerId(String email, String password) throws Exception{
//		Customer customer = applicationDao.getCustomer(email, password);
//		if(customer == null) {
//			throw new RuntimeException("Not able to find customer. ");
//		}
//		return customer.getId();
//	}
//	
//	public Customer getCustomer(String email, String password) throws Exception{
//		Customer customer = applicationDao.getCustomer(email, password);
//		if(customer == null) {
//			throw new RuntimeException("Not able to find customer. ");
//		}
//		return customer;
//	}
	
	public List<Room> getRoomsList() {
		return applicationDao.getRoomsList();
	}
	
	public List<BookingDetails> getBookingDetails() {
		return applicationDao.getBookingList();
	}

	@Override
	public BookingDetails bookRoom(RoomBookingReqDto roomBookingDetails) throws Exception{
//		boolean isBooked = false;
		if(roomBookingDetails.getStartDate().compareTo(roomBookingDetails.getEndDate()) > 0 ) {
			throw new RuntimeException("Reservation start date cant be after the reservation end date.");
		}
		
//		Customer customer = applicationDao.getCustomer(roomBookingDetails.getCustomerId());
		Customer customer = customerService.getCustomer(roomBookingDetails.getCustomerId());
		if(customer == null) {
			throw new RuntimeException("Invalid Customer Id...");
		}
		
		boolean isRoomAvailbe = applicationDao.isRoomAvailable(roomBookingDetails.getRoomId(), roomBookingDetails.getStartDate(), roomBookingDetails.getEndDate());
		if(!isRoomAvailbe) {
			throw new RuntimeException("room is not available for specified date range. ");
		}
		
		Room room = applicationDao.getRoom(roomBookingDetails.getRoomId());
		BookingDetails bookDetails = new BookingDetails();
		bookDetails.setCustomer(customer);
		bookDetails.setRoom(room);
		bookDetails.setReservationStartDate(roomBookingDetails.getStartDate());
		bookDetails.setReservationEndDate(roomBookingDetails.getEndDate());
		applicationDao.saveOrUpdateRoomBooking(bookDetails);
		return bookDetails;
	}

}
