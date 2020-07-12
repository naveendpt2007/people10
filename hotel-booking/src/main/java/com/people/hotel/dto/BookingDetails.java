package com.people.hotel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="booking_details")
public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "booking_id_generator")
    @SequenceGenerator(name = "booking_id_generator", sequenceName = "booking_id_seq", allocationSize=1)
	@Column(name="id", unique=true)
	private Integer id;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Room room;
	
	@Column(name="start_date")
	private Date reservationStartDate;
	
	@Column(name="end_date")
	private Date reservationEndDate;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}
	/**
	 * @return the reservationStartDate
	 */
	public Date getReservationStartDate() {
		return reservationStartDate;
	}
	/**
	 * @param reservationStartDate the reservationStartDate to set
	 */
	public void setReservationStartDate(Date reservationStartDate) {
		this.reservationStartDate = reservationStartDate;
	}
	/**
	 * @return the reservationEndDate
	 */
	public Date getReservationEndDate() {
		return reservationEndDate;
	}
	/**
	 * @param reservationEndDate the reservationEndDate to set
	 */
	public void setReservationEndDate(Date reservationEndDate) {
		this.reservationEndDate = reservationEndDate;
	}

}
