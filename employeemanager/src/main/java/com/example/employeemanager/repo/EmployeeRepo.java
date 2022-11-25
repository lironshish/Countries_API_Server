package com.example.employeemanager.repo;

import com.example.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
   /*Spring is able to understand this language and then create the query for us -> to delete an employee by ID*/

    /* Optional -> Maybe the employee doesn't exist*/

    Optional<Employee> findEmployeeById(Long id);

    void deleteEmployeeById(Long id);
}
