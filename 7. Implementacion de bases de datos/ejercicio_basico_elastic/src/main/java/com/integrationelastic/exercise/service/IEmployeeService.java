package com.integrationelastic.exercise.service;

import com.integrationelastic.exercise.dto.EmployeeDto;
import com.integrationelastic.exercise.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {
    ResponseDto saveEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAll();
}
