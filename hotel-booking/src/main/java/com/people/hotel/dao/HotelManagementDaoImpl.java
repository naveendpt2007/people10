package com.people.hotel.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.people.hotel.dto.BookingDetails;
import com.people.hotel.dto.Customer;
import com.people.hotel.dto.Room;

@Repository
public class HotelManagementDaoImpl implements HotelManagementDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Room> getRoomsList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Room> list= session.createCriteria(Room.class).list();
		return list;
	}
	
	public List<BookingDetails> getBookingList(){
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<BookingDetails> list= session.createCriteria(BookingDetails.class).list();
		return list;
	}
	
	public Customer getCustomer(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		StringBuffer qryString = new StringBuffer().append("from Customer ");		
			qryString.append(" where email = :email and password = :password ");
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(qryString.toString());
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Customer> customerList = (List<Customer>)q.list();
		if(customerList.size() > 0) {
			return customerList.get(0);
		}
		return null;
	}
	
	public boolean isCustomerExists(String email) {
		Session session = sessionFactory.getCurrentSession();
		Criteria query = session.createCriteria(Customer.class);
		query.add(Restrictions.like("email", email, MatchMode.START));
		List<Customer> customerList = (List<Customer>)query.list();
		if(customerList.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCustomerExists(long id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria query = session.createCriteria(Customer.class);
		query.add(Restrictions.eq("id", id));
		List<Customer> customerList = (List<Customer>)query.list();
		if(customerList.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomer(long id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria query = session.createCriteria(Customer.class);
		query.add(Restrictions.eq("id", id));
		List<Customer> customerList = (List<Customer>)query.list();
		if(customerList.size() > 0) {
			return customerList.get(0);
		}
		return null;
	}

	@Override
	public Room getRoom(long id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria query = session.createCriteria(Room.class);
		query.add(Restrictions.eq("id", id));
		List<Room> roomList = (List<Room>)query.list();
		if(roomList.size() > 0) {
			return roomList.get(0);
		}
		return null;
	}

	@Override
	public boolean isRoomAvailable(long roomId, Date startDate, Date endDate) {
		Session session = sessionFactory.getCurrentSession();
		StringBuffer qryString = new StringBuffer().append(" SELECT count(*) FROM booking_details WHERE ");		
			qryString.append(" room_id = :roomId and ");
			qryString.append(" ((start_date BETWEEN :rStartDate AND :rEndDate) OR  ");
			qryString.append(" (end_date BETWEEN :rStartDate AND :rEndDate) OR  ");
			qryString.append(" (end_date <= :rStartDate AND end_date >= :rEndDate)) ");
		@SuppressWarnings("rawtypes")
		Query q = session.createSQLQuery(qryString.toString());
		q.setParameter("roomId", roomId);
		q.setParameter("rStartDate", startDate);
		q.setParameter("rEndDate", endDate);
		int subBatchCount = ((BigInteger) q.uniqueResult()).intValue();
        	if (subBatchCount == 1)
        		return false;
        	return true;
	}
	
	public void saveOrUpdate(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer); 
	}
	
	public void saveOrUpdate(Room room) {
		Session session = sessionFactory.getCurrentSession();
		session.save(room); 
	}

	@Override
	public void saveOrUpdateRoomBooking(BookingDetails bookDetails) {
		Session session = sessionFactory.getCurrentSession();
		session.save(bookDetails); 
	}

}
