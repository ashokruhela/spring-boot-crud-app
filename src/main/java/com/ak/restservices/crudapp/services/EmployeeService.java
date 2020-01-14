package com.ak.restservices.crudapp.services;

import com.ak.restservices.crudapp.model.Employee;
import com.ak.restservices.crudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeList() {
        List<Employee> employees = new ArrayList<>();
//        employeeRepository.findAll().forEach(e -> { employees.add(e);});
        employeeRepository.findAll().forEach(employees::add);
        employees.forEach(e -> System.out.println(e));
        return employees;
    }
}