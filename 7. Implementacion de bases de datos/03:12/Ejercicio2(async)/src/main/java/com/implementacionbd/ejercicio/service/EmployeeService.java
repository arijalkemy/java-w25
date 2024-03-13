package com.implementacionbd.ejercicio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.implementacionbd.ejercicio.dto.req.EmployeeReqDTO;
import com.implementacionbd.ejercicio.dto.res.CityResDTO;
import com.implementacionbd.ejercicio.dto.res.EmployeeResDTO;
import com.implementacionbd.ejercicio.model.City;
import com.implementacionbd.ejercicio.model.Employee;
import com.implementacionbd.ejercicio.repository.IEmployeeRepository;

@Service
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private Employee employeeReqDTOToModel(EmployeeReqDTO employeeReqDTO) {
        City city = new City(employeeReqDTO.getCity().getName());
        return new Employee(employeeReqDTO.getName(), employeeReqDTO.getLastName(), employeeReqDTO.getAge(), city);
    }

    private EmployeeResDTO employeeModelToResDTO(Employee employee) {
        CityResDTO cityResDTO = new CityResDTO(employee.getCity().getName());
        return new EmployeeResDTO(employee.getId(), employee.getName(), employee.getLastName(), employee.getAge(),
                cityResDTO);
    }

    public List<EmployeeResDTO> findAllEmployees() {
        Iterable<Employee> employeesIterable = employeeRepository.findAll();
        List<Employee> employeesList = StreamSupport.stream(employeesIterable.spliterator(), false)
                .collect(Collectors.toList());
        List<EmployeeResDTO> employeesResDTOList = new ArrayList<>();
        for (Employee e : employeesList) {
            employeesResDTOList.add(employeeModelToResDTO(e));
        }
        return employeesResDTOList;
    }

    public String saveEmployee(EmployeeReqDTO employeeReqDTO) {
        employeeRepository.save(employeeReqDTOToModel(employeeReqDTO));
        return "Ok";
    }

    public String deleteEmployee(String id) {
        employeeRepository.deleteById(id);
        return "Ok";
    }

    public String updateEmployee(String id, EmployeeReqDTO employeeReqDTO) {
        Employee employee = employeeReqDTOToModel(employeeReqDTO);
        employee.setId(id);
        employeeRepository.save(employee);
        return "Ok";
    }
}
