package com.mw.hibernate.demo;

import com.mw.hibernate.demo.entity.Instructor;
import com.mw.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
            Instructor instructor = new Instructor("Chad1", "Darby", "darby@luvtocode.com");

            instructorDetail.setInstructor(instructor);

            session.beginTransaction();
            session.save(instructorDetail);
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
