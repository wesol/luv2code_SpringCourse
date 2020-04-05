package com.mw.restproject.service;

import com.mw.restproject.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(long employeeId);

    void add(Employee employee);

    void update(Employee employee);

    void delete(long employeeId);
}
