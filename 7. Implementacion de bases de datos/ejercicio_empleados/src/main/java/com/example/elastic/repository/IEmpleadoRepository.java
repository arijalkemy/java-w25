package com.example.elastic.repository;

import com.example.elastic.model.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, Integer> {

    public List<Empleado> findAll();

}
