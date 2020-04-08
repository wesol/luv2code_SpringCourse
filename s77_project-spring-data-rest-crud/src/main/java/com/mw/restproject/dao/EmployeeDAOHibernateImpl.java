package com.mw.restproject.dao;

import com.mw.restproject.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {

        Session session = entityManager.unwrap(Session.class);

        Query<Employee> employeeQuery = session.createQuery("from Employee", Employee.class);

        return employeeQuery.getResultList();
    }

    @Override
    public Employee findById(long employeeId) {

        Session session = entityManager.unwrap(Session.class);

        return session.get(Employee.class, employeeId);
    }

    @Override
    public void save(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(long employeeId) {

        Session session = entityManager.unwrap(Session.class);

        Query<Employee> employeeQuery = session.createQuery("delete from Employee where id=:id");
        employeeQuery.setParameter("id", employeeId);

        employeeQuery.executeUpdate();
    }
}
