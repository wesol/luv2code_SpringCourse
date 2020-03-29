package com.mw.springdemo.rest;


import com.mw.springdemo.dao.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainRestController {

    @GetMapping("/hello")
    public String sayHello() {

        return "Hello its work with simple string!";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Mark","Smith"));
        students.add(new Student("Mat","Wes"));
        students.add(new Student("Kunekunda","Boska"));

        return students;
    }

}



