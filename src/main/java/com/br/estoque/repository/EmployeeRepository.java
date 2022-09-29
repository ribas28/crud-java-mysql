package com.br.estoque.repository;

import com.br.estoque.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByEmail(String email);

}
