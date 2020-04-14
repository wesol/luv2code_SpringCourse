package com.mw.springbootthymeleaf.controller;

import com.mw.springbootthymeleaf.entity.Employee;
import com.mw.springbootthymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // If is only one constructor @Autowired is optional
    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Employee> employees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", employees);

        return "list-employees";
    }
}

