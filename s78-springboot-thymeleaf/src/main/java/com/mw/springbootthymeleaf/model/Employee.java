package com.mw.springbootthymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

}
