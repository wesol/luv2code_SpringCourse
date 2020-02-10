package com.mw.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CustomerController {

    @RequestMapping("/list")
    public String listCustomer(Model model){

        return "list-customer";
    }

}
