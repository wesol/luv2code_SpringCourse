package com.mw.springbootthymeleaf.service;


import com.mw.springbootthymeleaf.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllByOrderByLastNameAsc();

    Employee findById(int employeeId);

    void add(Employee employee);

    void update(Employee employee);

    void delete(int employeeId);
}
