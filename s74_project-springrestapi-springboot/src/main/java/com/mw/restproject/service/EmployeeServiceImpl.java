package com.mw.restproject.service;


import com.mw.restproject.dao.EmployeeDAO;
import com.mw.restproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(long employeeId) {

        return employeeDAO.findById(employeeId);
    }

    @Override
    @Transactional
    public void add(Employee employee) {

        employee.setId(0);

        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {

        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(long employeeId) {

        employeeDAO.delete(employeeId);
    }


}
