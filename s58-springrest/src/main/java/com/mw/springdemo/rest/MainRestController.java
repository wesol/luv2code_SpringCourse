package com.mw.springdemo.rest;


import com.mw.springdemo.dao.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainRestController {

    List<Student> students;

    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("Mark", "Smith"));
        students.add(new Student("Mat", "Wes"));
        students.add(new Student("Kunekunda", "Boska"));
    }


    @GetMapping("/hello")
    public String sayHello() {

        return "Hello its work with simple string!";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        return students.get(studentId);
    }

}



