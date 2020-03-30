package com.mw.springdemo.rest;


import com.mw.springdemo.entity.Customer;
import com.mw.springdemo.rest.exception.CustomerNotFoundException;
import com.mw.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){

        Optional<Customer> customer = Optional.ofNullable(customerService.getCustomer(customerId));

        if (!customer.isPresent())
            throw new CustomerNotFoundException("Not found customer with id: " + customerId);

        return customer.get();
    }

}
