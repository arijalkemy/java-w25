package com.bootcamp.ejercicio_empleados_elastic.repository;

import com.bootcamp.ejercicio_empleados_elastic.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, Integer> {
}
