package com.example.elasticDemo.services;

import com.example.elasticDemo.dto.EmployeeDTO;
import com.example.elasticDemo.dto.ResponseDTO;
import org.apache.coyote.Response;

import java.util.List;

public interface IEmployeeService {
    ResponseDTO save(EmployeeDTO employeeDTO);
    List<EmployeeDTO> findAll();

}
