package com.people.hotel.service;

import com.people.hotel.dto.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws Exception;
	public long getCustomerId(String email, String password) throws Exception;
	public Customer getCustomer(String email, String password)throws Exception;
	public Customer getCustomer(long id)throws Exception;
	public boolean isCustomerExists(String email);

}
