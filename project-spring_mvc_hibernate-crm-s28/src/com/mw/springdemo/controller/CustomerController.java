package com.mw.springdemo.controller;

import com.mw.springdemo.dao.CustomerDAO;
import com.mw.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerController {

    private CustomerDAO customerDAO;

    public CustomerController() {
        System.out.println("no parameter");
    }

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
        System.out.println("One parameter");
    }

    @GetMapping("/list")
    public String listCustomer(Model model) {

        List<Customer> customers = customerDAO.getCustomers();

        model.addAttribute("customers", customers);

        return "list-customer";
    }

}
