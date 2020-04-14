package com.mw.springbootthymeleaf.dao;

import com.mw.springbootthymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
