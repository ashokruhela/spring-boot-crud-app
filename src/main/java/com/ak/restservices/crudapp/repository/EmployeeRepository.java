package com.ak.restservices.crudapp.repository;

import com.ak.restservices.crudapp.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
