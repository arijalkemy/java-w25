package com.example.ElasticDemo01.service;

import com.example.ElasticDemo01.dto.EmployeeDto;
import com.example.ElasticDemo01.dto.ResponseDto;
import com.example.ElasticDemo01.entity.Employee;
import com.example.ElasticDemo01.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.matcher.StringMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.ElasticDemo01.util.MapperClass.dtoToEntity;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    IEmployeeRepository repository;

    public EmployeeServiceImpl(IEmployeeRepository repository){
        this.repository = repository;
    }
    @Override
    public ResponseDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = dtoToEntity(employeeDto);
        repository.save(employee);
        return new ResponseDto("It's all fine");
    }

    @Override
    public List<EmployeeDto> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<Employee> employees = repository.findAll();

        return employees.stream().map(e -> mapper.map(e,EmployeeDto.class)).toList();
    }
}
