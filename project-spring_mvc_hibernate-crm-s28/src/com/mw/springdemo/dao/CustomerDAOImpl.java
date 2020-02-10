package com.mw.springdemo.dao;

import com.mw.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("select c from Customer c");
        List<Customer> customersList = customersList = query.getResultList();

        return customersList;
    }


}
