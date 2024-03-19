package com.example.ElasticDemo01.util;

import com.example.ElasticDemo01.dto.EmployeeDto;
import com.example.ElasticDemo01.entity.Employee;

public class MapperClass {
    public static Employee dtoToEntity(EmployeeDto employeeDto){
        return new Employee(employeeDto.getName()
        ,employeeDto.getLastname()
        ,employeeDto.getAge()
        ,employeeDto.getCountry()
        ,employeeDto.getDateOfBirth());
    }

    public static EmployeeDto entityToDto(Employee employee){
        return new EmployeeDto(employee.getName()
                ,employee.getLastname()
                ,employee.getAge()
                ,employee.getCountry()
                ,employee.getDateOfBirth());
    }

}
