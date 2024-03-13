package org.example.elasticdemo1.service;

import org.example.elasticdemo1.dto.EmployeeDto;
import org.example.elasticdemo1.dto.ResponseDto;
import org.example.elasticdemo1.entity.Employee;
import org.example.elasticdemo1.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.elasticdemo1.util.MapperClass.dtoToEntity;
import static org.example.elasticdemo1.util.MapperClass.entityToDto;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private  IEmployeeRepository repository;

    public EmployeeServiceImpl(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = dtoToEntity(employeeDto);
        var a =repository.save(employee);
        return new ResponseDto("Todo ok");
    }

    @Override
    public List<EmployeeDto> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<Employee> employees = repository.findAll();

        List<EmployeeDto> employeeDtos = employees.stream().map(e -> mapper.map(e, EmployeeDto.class)).toList();
        return employeeDtos;
    }
}
