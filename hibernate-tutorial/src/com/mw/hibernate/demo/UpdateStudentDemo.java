package com.mw.hibernate.demo;

import com.mw.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {


    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // One student
            session.beginTransaction();

            long id = 1;
            Student student = session.get(Student.class, id);
            System.out.println("Updating student");
            student.setFirstName("New");
            session.getTransaction().commit();

            // One student or more
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='new@email'").executeUpdate();
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }


}
