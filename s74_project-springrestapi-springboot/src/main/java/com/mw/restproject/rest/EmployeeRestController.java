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

        Employee employee = employeeService.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee is not found, id=" + employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

       employeeService.add(employee);

       return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.update(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable long employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee is not found, id=" + employeeId);
        }

        employeeService.delete(employeeId);

        return "Employee with id:" + employeeId + " has been deleted";
    }
}
