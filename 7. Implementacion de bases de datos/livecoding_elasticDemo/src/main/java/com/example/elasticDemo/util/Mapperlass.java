package com.example.elasticDemo.util;

import com.example.elasticDemo.dto.EmployeeDTO;
import com.example.elasticDemo.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapperlass {
    // Todos los metodos aca son estaticos
    public static Employee dtoToEntity(EmployeeDTO employeeDTO){
        return new Employee(null,
                employeeDTO.getName(),
                employeeDTO.getLastname(),
                employeeDTO.getAge(),
                employeeDTO.getCountry(),
                employeeDTO.getDateOfBirth());
    }

    public static EmployeeDTO entityToDto(Employee employee){
        return new EmployeeDTO(null,
                employee.getName(),
                employee.getLastname(),
                employee.getAge(),
                employee.getCountry(),
                employee.getDateOfBirth());
    }
}
