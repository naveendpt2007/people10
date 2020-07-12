package com.people.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.people.hotel.dto.BookingDetails;
import com.people.hotel.dto.Customer;
import com.people.hotel.dto.Room;
import com.people.hotel.dto.RoomBookingReqDto;
import com.people.hotel.service.RoomService;
import com.people.hotel.service.CustomerService;

@RestController
@RequestMapping("/api")
public class HotelManagementController {
	
	@Autowired
	RoomService service;
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/createCustomer",headers="Accept=application/json")
	public ResponseEntity<?> createCustomer(@RequestBody Customer cust, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Customer "+cust.getEmail());
		try {
			customerService.addCustomer(cust);
			return ResponseEntity.status(HttpStatus.OK).body(cust);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
	
	@PostMapping(value = "/addRoom",headers="Accept=application/json")
	public ResponseEntity<?> createRoom(@RequestBody Room room) {
		System.out.println("Adding new Room..");
		try {
			service.addRoom(room);
			return ResponseEntity.status(HttpStatus.OK).body("Room Successfully created..");
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
	
	@GetMapping(value = "/getCustomerId/{email}/{password}")
	public ResponseEntity<?> getCustomerId(@PathVariable("email") String email, @PathVariable("password") String password) {
		System.out.println("Email : " + email);
		System.out.println("password : " + password);
		try {
			long customerId = customerService.getCustomerId(email, password);
			return ResponseEntity.status(HttpStatus.OK).body(customerId);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
	
	@GetMapping(value = "/getCustomer/{email}/{password}")
	public ResponseEntity<?> getCustomer(@PathVariable("email") String email, @PathVariable("password") String password) {
		System.out.println("Email : " + email);
		System.out.println("password : " + password);
		try {
			Customer customer = customerService.getCustomer(email, password);
			return ResponseEntity.status(HttpStatus.OK).body(customer);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
	
	@GetMapping(value = "/getRoomsList")
	public ResponseEntity<?> getRoomsList() {
		System.out.println("getRoomsList");
		List<Room> roomList = service.getRoomsList();
		return ResponseEntity.status(HttpStatus.OK).body(roomList);
	}
	
	@GetMapping(value = "/getBookingList")
	public List<BookingDetails> getBookingList() {
		System.out.println("Getting Booking details : ");
		List<BookingDetails> bookingDetailsList = service.getBookingDetails();
		return bookingDetailsList;
	}
	
	@GetMapping(value = "/isCustomerExists/{email}")
	public boolean getCustomerExists(@PathVariable("email") String email) {
		System.out.println("Checking is customer... ");
		return customerService.isCustomerExists(email);
	}
	
	@PostMapping(value = "/bookRoom", headers="Accept=application/json")
	public ResponseEntity<?> getBookARoom(@RequestBody RoomBookingReqDto roomBookingDetails) {
		System.out.println("Booking the Room : ");
		try {
			BookingDetails bookingDetails = service.bookRoom(roomBookingDetails);
			return ResponseEntity.status(HttpStatus.CREATED).body(bookingDetails);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
//		if(!isRoomBooked) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to book the room, Either customer doesnt exists / Rooms are not available.");
//		}else {
//			return ResponseEntity.status(HttpStatus.CREATED).body("Room has been Booked Successfully..");
//		}
	}
}
