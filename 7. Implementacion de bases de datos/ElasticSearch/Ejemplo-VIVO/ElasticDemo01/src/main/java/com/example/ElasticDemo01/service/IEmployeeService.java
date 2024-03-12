package com.example.ElasticDemo01.service;

import com.example.ElasticDemo01.dto.EmployeeDto;
import com.example.ElasticDemo01.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEmployeeService {

    ResponseDto saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAll();
}
