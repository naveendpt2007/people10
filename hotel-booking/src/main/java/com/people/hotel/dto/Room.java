package com.people.hotel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="room_def")
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "room_id_generator")
    @SequenceGenerator(name = "room_id_generator", sequenceName = "room_id_seq", allocationSize=1)
	@Column(name="id", unique=true)
	private Long id;
	
	@Column(name="room_type")
	private String roomType;
	
	@Column(name="rent")
	private Integer rent;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}
	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	/**
	 * @return the rent
	 */
	public Integer getRent() {
		return rent;
	}
	/**
	 * @param rent the rent to set
	 */
	public void setRent(Integer rent) {
		this.rent = rent;
	}

}
