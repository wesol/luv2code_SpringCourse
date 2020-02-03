package com.mw.hibernate.demo;

import com.mw.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {


    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> studentList = session.createQuery("from Student s where s.lastName = 'Kowalski'" +
                    "OR s.lastName = 'Lee' OR email LIKE '%luv2code.com'").getResultList();

            // session.getTransaction().commit(); // it close session!

            displayStudents(studentList);

            System.out.println("\n**************And all:\n");

            studentList = session.createQuery("from Student").getResultList();

            displayStudents(studentList);

        } finally {
            session.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
