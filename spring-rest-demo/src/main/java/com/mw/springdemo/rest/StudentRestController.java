package com.mw.springdemo.rest;


import com.mw.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("Poorina", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));

    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }


}
