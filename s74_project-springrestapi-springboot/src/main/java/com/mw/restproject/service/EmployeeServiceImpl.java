package com.mw.restproject.service;


import com.mw.restproject.dao.EmployeeRepository;
import com.mw.restproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(long employeeId) {

        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;

        if (result.isPresent()){
            employee = result.get();
        } else {
            throw new RuntimeException("Not found employee with id = " + employeeId);
        }
        return employee;
    }

    @Override
    @Transactional
    public void add(Employee employee) {

        employee.setId(0);

        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(long employeeId) {

        employeeRepository.deleteById(employeeId);
    }


}
