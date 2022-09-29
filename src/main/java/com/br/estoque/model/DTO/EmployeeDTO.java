package com.br.estoque.model.DTO;

import com.br.estoque.model.Employee;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;
    private String first_name;
    private String last_name;
    private String email;

    public EmployeeDTO(Employee employee) {
            this.id = employee.getId();
            this.first_name = employee.getFirstName();
            this.last_name = employee.getLastName();
            this.email = employee.getEmail();
    }

    public static List<EmployeeDTO> converter(List<Employee> topicos) {
        return topicos.stream().map(EmployeeDTO::new).collect(Collectors.toList());
    }
}
