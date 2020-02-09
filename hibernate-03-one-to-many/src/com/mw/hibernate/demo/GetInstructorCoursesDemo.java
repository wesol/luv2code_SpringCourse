package com.mw.hibernate.demo;

import com.mw.hibernate.demo.entity.Course;
import com.mw.hibernate.demo.entity.Instructor;
import com.mw.hibernate.demo.entity.InstructorDetail;
import com.mw.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(Review.class)
                                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println("Instructor courses: " + instructor.getCourses());
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
