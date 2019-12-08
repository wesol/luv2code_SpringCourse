package com.mw.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping("/showForm")
    public String showForm() {
        System.out.println("Show form");
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        System.out.println("processForm");
        return "process-form-hello";
    }


    @RequestMapping("/processFormV2")
    public String workModel(HttpServletRequest request, Model model) {

        String theName = request.getParameter("studentName").toUpperCase();
        String result = "Yo! " + theName;

        model.addAttribute("message", result);

        return "process-form-hello";
    }

    @RequestMapping("/processFormV3")
    public String workModelV3(
            @RequestParam("studentName") String theName,
            Model model) {

        theName = theName.toUpperCase();
        String result = "Yo! from v3 " + theName;

        model.addAttribute("message", result);

        return "process-form-hello";
    }
}
