package com.mw.springdemo.service;

import com.mw.springdemo.entity.Customer;
import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
