package com.mw.restproject.rest;

import com.mw.restproject.entity.Employee;
import com.mw.restproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeByID(@PathVariable long employeeId) {


        return null;
    }

    @PostMapping("/employees")
    public Employee addEmployee(Employee employee) {


        return null;
    }

    @PutMapping("/employees")
    public String updateEmployee(Employee employee) {


        return null;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable long employeeId) {

        return null;
    }
}
