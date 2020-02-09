package com.mw.hibernate.demo;

import com.mw.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(Review.class)
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            Instructor instructor;

            session.beginTransaction();

            instructor = session.get(Instructor.class, 1);

            Course guitarCourse = new Course("Guitar course");
            Course javaCourse = new Course("Java course");

            instructor.add(guitarCourse);
            instructor.add(javaCourse);

            session.save(guitarCourse);
            session.save(javaCourse);

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
