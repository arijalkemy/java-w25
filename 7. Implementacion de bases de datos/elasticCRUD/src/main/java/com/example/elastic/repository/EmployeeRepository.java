package com.example.elastic.repository;

import com.example.elastic.model.Employee;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, Integer> {

    @Query (
            """
            {
              "query": {
                "match_all": {}
                }
            }
            """
    )
    List<Employee> findAll();

}
