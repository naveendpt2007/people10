package com.people.hotel.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people.hotel.dao.HotelManagementDao;
import com.people.hotel.dto.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	HotelManagementDao applicationDao;

	public Customer addCustomer(Customer customer) throws Exception{
//		boolean isCreated = false;
		int passWordLength = customer.getPassword().length();
		
		if(passWordLength < 8 || passWordLength > 10) {
			throw new RuntimeException("password length should between 8 to 10 characters..");
		}
		
		boolean isExists = applicationDao.isCustomerExists(customer.getEmail());
		if(isExists) {
			throw new RuntimeException("Customer with email is already Exists..");
		}
		applicationDao.saveOrUpdate(customer);
		return customer;
	}
	
	public boolean isCustomerExists(String email) {
		return applicationDao.isCustomerExists(email);
	}
	
	public long getCustomerId(String email, String password) throws Exception{
		Customer customer = applicationDao.getCustomer(email, password);
		if(customer == null) {
			throw new RuntimeException("Not able to find customer. ");
		}
		return customer.getId();
	}
	
	public Customer getCustomer(String email, String password) throws Exception{
		Customer customer = applicationDao.getCustomer(email, password);
		if(customer == null) {
			throw new RuntimeException("Not able to find customer. ");
		}
		return customer;
	}
	
	public Customer getCustomer(long id) throws Exception{
		Customer customer = applicationDao.getCustomer(id);
		if(customer == null) {
			throw new RuntimeException("Not able to find customer. ");
		}
		return customer;
	}
	
}
