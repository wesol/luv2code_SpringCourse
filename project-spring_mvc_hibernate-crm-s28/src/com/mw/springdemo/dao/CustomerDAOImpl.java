package com.mw.springdemo.dao;

import com.mw.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer", Customer.class);

        return query.getResultList();
    }


}
