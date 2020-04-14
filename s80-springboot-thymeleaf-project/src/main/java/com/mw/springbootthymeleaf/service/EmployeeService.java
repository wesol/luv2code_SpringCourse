package com.mw.springbootthymeleaf.service;


import com.mw.springbootthymeleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int employeeId);

    void add(Employee employee);

    void update(Employee employee);

    void delete(int employeeId);
}
