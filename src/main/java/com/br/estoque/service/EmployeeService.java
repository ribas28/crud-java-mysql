package com.br.estoque.service;

import com.br.estoque.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
        Employee saveEmployee(Employee employee);
        List<Employee> getAllEmployees();
        Optional<Employee> getEmployeeById(long id);
        Employee updateEmployee(Employee updatedEmployee);
        void deleteEmployee(long id);
}
