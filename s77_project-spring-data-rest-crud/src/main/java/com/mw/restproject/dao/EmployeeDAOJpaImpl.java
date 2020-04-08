package com.mw.restproject.dao;

import com.mw.restproject.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Employee> findAll() {

        Query query = entityManager.createQuery("from Employee");

        return query.getResultList();
    }

    @Override
    public Employee findById(long employeeId) {

        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public void save(Employee employee) {

        entityManager.merge(employee);
    }

    @Override
    public void delete(long employeeId) {

        Query employeeQuery = entityManager.createQuery("delete from Employee where id=:id");
        employeeQuery.setParameter("id", employeeId);

        employeeQuery.executeUpdate();
    }
}
