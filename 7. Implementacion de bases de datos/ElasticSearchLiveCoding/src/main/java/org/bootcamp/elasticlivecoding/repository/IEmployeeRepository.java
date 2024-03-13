package org.bootcamp.elasticlivecoding.repository;

import org.bootcamp.elasticlivecoding.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee,String> {
    List<Employee> findAll();
}
