package com.mw.springdemo.dao;

import com.mw.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
