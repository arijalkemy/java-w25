package com.example.elastic.service;

import com.example.elastic.model.Employee;
import com.example.elastic.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpEmployeeService implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save (Employee emp) {

        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    //va optional porque puede que devuelva como puede que no
    public Optional<Employee> findById (int id) {
        return employeeRepository.findById(id);

    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Artículo eliminado correctamente";
    }

    @Override
    public String editEmployee(Employee art) {
        employeeRepository.save(art);
        return "Articulo modificado correctamente";
    }
}
