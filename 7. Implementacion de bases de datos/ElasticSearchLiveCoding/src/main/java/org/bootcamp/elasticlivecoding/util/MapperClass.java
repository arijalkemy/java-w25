package org.bootcamp.elasticlivecoding.util;

import org.bootcamp.elasticlivecoding.dto.EmployeeDto;
import org.bootcamp.elasticlivecoding.entity.Employee;

public class MapperClass {

    public static Employee dtoToEntity(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getName(),
                employeeDto.getLastname(),
                employeeDto.getAge(),
                employeeDto.getCountry(),
                employeeDto.getDateOfBirth()
        );
    }
}
