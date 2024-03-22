package com.integrationelastic.exercise.utils;

import com.integrationelastic.exercise.dto.EmployeeDto;
import com.integrationelastic.exercise.entity.Employee;

public class MapperClass {
    public static Employee dtoToEntity(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getName(),
                employeeDto.getLastName(),
                employeeDto.getAge(),
                employeeDto.getCountry(),
                employeeDto.getDateOfBirth()
        );
    }

    public static EmployeeDto entityToDto(Employee employee){
        return new EmployeeDto(
                employee.getName(),
                employee.getLastName(),
                employee.getAge(),
                employee.getCountry(),
                employee.getDateOfBirth()
        );
    }
}
