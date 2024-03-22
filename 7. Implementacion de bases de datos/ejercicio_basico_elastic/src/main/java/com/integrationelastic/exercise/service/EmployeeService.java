package com.integrationelastic.exercise.service;


import com.integrationelastic.exercise.dto.EmployeeDto;
import com.integrationelastic.exercise.dto.ResponseDto;
import com.integrationelastic.exercise.entity.Employee;
import com.integrationelastic.exercise.repository.IEmployeeRepository;
import com.integrationelastic.exercise.utils.MapperClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee= MapperClass.dtoToEntity(employeeDto);
        employeeRepository.save(employee);
        return new ResponseDto("Its all fine");
    }

    @Override
    public List<EmployeeDto> getAll() {
        ModelMapper mapper=new ModelMapper();
        return employeeRepository.findAll().stream().map(employee -> mapper.map(employee, EmployeeDto.class)).toList();
    }
}
