package com.mw.hibernate.demo;

import com.mw.hibernate.demo.entity.Course;
import com.mw.hibernate.demo.entity.Instructor;
import com.mw.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            //Retrieving the instructor with courses by JOIN FETCH from database
            Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id = :theInstructorId");
            query.setParameter("theInstructorId", 1);

            Instructor instructor = query.getSingleResult();
            session.close();

            System.out.println(instructor);
        } finally {
            session.close();
            factory.close();
        }
    }
}
