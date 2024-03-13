package org.example.elasticdemo1.service;

import org.example.elasticdemo1.dto.EmployeeDto;
import org.example.elasticdemo1.dto.ResponseDto;

import java.util.List;

public interface IEmployeeService {
    ResponseDto saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAll();
}
