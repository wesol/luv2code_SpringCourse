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

    @Transactional
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }


}
