package org.bootcamp.elasticlivecoding.service;

import org.bootcamp.elasticlivecoding.dto.EmployeeDto;
import org.bootcamp.elasticlivecoding.dto.ResponseDto;
import org.bootcamp.elasticlivecoding.entity.Employee;
import org.bootcamp.elasticlivecoding.repository.IEmployeeRepository;
import org.bootcamp.elasticlivecoding.util.MapperClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    IEmployeeRepository employeeRepository;

    public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = MapperClass.dtoToEntity(employeeDto);
        employeeRepository.save(employee);
        return new ResponseDto("Employee saved successfully");
    }

    @Override
    public List<EmployeeDto> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).toList();
    }
}
