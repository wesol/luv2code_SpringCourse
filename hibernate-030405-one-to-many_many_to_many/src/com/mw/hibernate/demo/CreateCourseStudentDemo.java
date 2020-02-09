package com.mw.hibernate.demo;

import com.mw.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseStudentDemo {

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

            session.beginTransaction();
            Course course = new Course("Pacman - how to score one million pounds");


            System.out.println("\nSaving the course" + course);
            session.save(course);
            System.out.println("\nSaved the course" + course);

            Student student1 = new Student("John", "Smith","john@luv2code.com");
            Student student2 = new Student("Mary", "Public","mary@luv2code.com");

            course.addStudent(student1);
            course.addStudent(student2);

            System.out.println("\nSaving students ...");
            session.save(student1);
            session.save(student2);
            System.out.println("\nSaved students: " + course.getStudents());

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
