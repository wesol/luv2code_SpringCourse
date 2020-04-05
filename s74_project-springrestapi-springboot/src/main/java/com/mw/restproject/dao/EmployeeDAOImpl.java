package com.mw.restproject.dao;

import com.mw.restproject.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {

        Session session = entityManager.unwrap(Session.class);

        Query<Employee> employeeQuery = session.createQuery("from Employee", Employee.class);

        return employeeQuery.getResultList();
    }
}
