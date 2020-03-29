package com.mw.springdemo.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainRestController {

    @GetMapping("/hello")
    public String sayHello() {

        return "Hello its work with simple string!";
    }

}



