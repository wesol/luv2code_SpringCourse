package com.mw.springdemo.service;

import java.util.List;

import com.mw.springdemo.model.Customer;

public interface CustomerServiceRestClient {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
