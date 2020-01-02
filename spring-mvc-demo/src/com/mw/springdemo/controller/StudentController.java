package com.mw.springdemo.controller;

import com.mw.springdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private HashMap<String, String> countryOptions;

    @Value("#{form_data.programming_languages}")
    private String[] programmingLanguages;

    @Value("#{form_data.operating_systems}")
    private String[] operatingSystems;

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countryOptions", countryOptions);
        theModel.addAttribute("programmingLanguages", programmingLanguages);
        theModel.addAttribute("operatingSystems", operatingSystems);

        return "student-form";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        return "student-confirmation";
    }


}
