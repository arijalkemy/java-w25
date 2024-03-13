package com.implementacionbd.ejercicio.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.implementacionbd.ejercicio.model.Employee;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
