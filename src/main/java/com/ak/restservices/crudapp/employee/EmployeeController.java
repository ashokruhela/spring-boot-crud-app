package com.ak.restservices.crudapp.employee;

import com.ak.restservices.crudapp.exception.ResourceNotFoundException;
import com.ak.restservices.crudapp.model.Employee;
import com.ak.restservices.crudapp.repository.EmployeeRepository;
import com.ak.restservices.crudapp.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> getUsers() {
        logger.info("getUsers called");
        return employeeService.getAllEmployeeList();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId)
            throws ResourceNotFoundException {
        List<Employee> employees = employeeService.getAllEmployeeList();
        if(employeeId <= 0 || employeeId > employees.size()) {
            throw new ResourceNotFoundException("employee not found");
        }
        return ResponseEntity.ok().body(employees.get((int)(employeeId -1)));
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployeeByIdAsParam(@RequestParam(value = "id") int employeeId)
            throws ResourceNotFoundException {
         Optional<Employee> employee = employeeRepository.findById(employeeId);

         if(!employee.isPresent()) {
             throw new ResourceNotFoundException("query param employee not found");
         }

        return ResponseEntity.ok().body(employee.get());
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return ResponseEntity.ok().body(emp);
    }
}
