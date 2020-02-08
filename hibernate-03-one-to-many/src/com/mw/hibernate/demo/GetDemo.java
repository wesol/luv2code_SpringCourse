package com.mw.hibernate.demo;

import com.mw.hibernate.demo.entity.Instructor;
import com.mw.hibernate.demo.entity.InstructorDetail;
import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int theID = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);

            if (instructorDetail == null) throw new NotFoundException("Not found InstructorDetail with id = " + theID);

            System.out.println("Found instructorDetail: " + instructorDetail.toString());

            session.getTransaction().commit();

            System.out.println("Done");
        } catch (NotFoundException e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
