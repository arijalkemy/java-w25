package com.example.elasticDemo.services;

import com.example.elasticDemo.dto.EmployeeDTO;
import com.example.elasticDemo.dto.ResponseDTO;
import com.example.elasticDemo.model.Employee;
import com.example.elasticDemo.repositories.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.elasticDemo.util.Mapperlass.dtoToEntity;

@Service
public class EmployeeServices implements IEmployeeService{

    IEmployeeRepository repository;

    public EmployeeServices(IEmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public ResponseDTO save(EmployeeDTO employeeDTO) {
        Employee employee = dtoToEntity(employeeDTO);
        repository.save(employee);
        return new ResponseDTO("hola hola");
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employees = (List<Employee>) repository.findAll();
        if(employees.isEmpty()) throw new RuntimeException("No hay nada");
        ModelMapper mapper = new ModelMapper();
        return employees.stream().map(m -> mapper.map(m, EmployeeDTO.class)).toList();
    }
}
