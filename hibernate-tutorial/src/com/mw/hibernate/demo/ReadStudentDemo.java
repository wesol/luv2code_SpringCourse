package com.mw.hibernate.demo;

import com.mw.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object.... ");
            Student student = new Student("Paul", "Smith", "paulsmith@mail.com");
            session.beginTransaction();
            System.out.println("Saving the student");
            session.save(student);
            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student studentRead = session.get(Student.class, student.getId());
            System.out.println("student is: " + studentRead);

            System.out.println("Done");

        } finally {
            session.close();
        }
    }
}
