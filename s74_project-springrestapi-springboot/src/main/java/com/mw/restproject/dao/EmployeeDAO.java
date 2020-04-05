package com.mw.restproject.dao;

import com.mw.restproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
