package com.example.elasticDemo.repositories;

import com.example.elasticDemo.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
    // List<Employee> findAll(); // Hay que hacerlo de esta forma porque si no hay que castearlo ose: (List<Employee>)
}
