package org.bootcamp.elasticlivecoding.service;

import org.bootcamp.elasticlivecoding.dto.EmployeeDto;
import org.bootcamp.elasticlivecoding.dto.ResponseDto;

import java.util.List;

public interface IEmployeeService {
    ResponseDto saveEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAll();
}
