package com.br.estoque.controller;

import com.br.estoque.model.DTO.EmployeeDTO;
import com.br.estoque.model.Employee;
import com.br.estoque.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

        private EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO){
            Employee employee = new Employee();
            employee.setEmail(employeeDTO.getEmail());
            employee.setFirstName(employeeDTO.getFirst_name());
            employee.setLastName(employeeDTO.getLast_name());
            return employeeService.saveEmployee(employee);
        }

        @GetMapping
        public List<Employee> getAllEmployees(){
            return employeeService.getAllEmployees();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
            return employeeService.getEmployeeById(employeeId)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId,
                                                       @RequestBody Employee employee){
            return employeeService.getEmployeeById(employeeId)
                    .map(savedEmployee -> {

                        savedEmployee.setFirstName(employee.getFirstName());
                        savedEmployee.setLastName(employee.getLastName());
                        savedEmployee.setEmail(employee.getEmail());

                        Employee updatedEmployee = employeeService.updateEmployee(savedEmployee);
                        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);

                    })
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){

            employeeService.deleteEmployee(employeeId);

            return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);

        }
}
