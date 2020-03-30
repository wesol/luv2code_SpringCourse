package com.mw.springdemo.rest;


import com.mw.springdemo.entity.Customer;
import com.mw.springdemo.rest.exception.CustomerNotFoundException;
import com.mw.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Optional<Customer> customer = Optional.ofNullable(customerService.getCustomer(customerId));

        if (!customer.isPresent())
            throw new CustomerNotFoundException("Not found customer with id: " + customerId);

        return customer.get();
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        // force INSERT a new customer
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.saveCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Optional<Customer> customer = Optional.ofNullable(customerService.getCustomer(customerId));

        if (!customer.isPresent())
            throw new CustomerNotFoundException("Not found customer with id: " + customerId);

        customerService.deleteCustomer(customerId);

        return "Deleted customer with id: " + customerId;
    }

}
