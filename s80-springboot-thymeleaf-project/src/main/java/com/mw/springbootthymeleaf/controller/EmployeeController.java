package com.mw.springbootthymeleaf.controller;

import com.mw.springbootthymeleaf.entity.Employee;
import com.mw.springbootthymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // If is only one constructor @Autowired is optional
    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Employee> employees = employeeService.findAllByOrderByLastNameAsc();

        // add to the spring model
        theModel.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormAdd")
    public String showFormForAdd(Model theModel) {

        Employee employee = new Employee();

        theModel.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model theModel) {

        Employee employee = employeeService.findById(employeeId);

        theModel.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int employeeId) {

        employeeService.delete(employeeId);

        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String showFormForAdd(@ModelAttribute("employee") Employee employee) {

        employeeService.update(employee);

        return "redirect:/employees/list";
    }

}

