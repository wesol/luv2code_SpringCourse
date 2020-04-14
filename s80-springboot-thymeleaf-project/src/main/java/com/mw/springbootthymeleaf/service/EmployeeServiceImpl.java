package com.mw.springbootthymeleaf.service;



import com.mw.springbootthymeleaf.dao.EmployeeRepository;
import com.mw.springbootthymeleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public List<Employee> findAllByOrderByLastNameAsc() {

        return employeeRepository.findAllByOrderByLastNameAsc();
    }


    @Override
    @Transactional
    public Employee findById(int employeeId) {

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
    public void delete(int employeeId) {

        employeeRepository.deleteById(employeeId);
    }


}
