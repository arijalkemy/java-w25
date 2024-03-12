package com.example.elastic.service;

import com.example.elastic.dto.EmpleadoDTO;
import com.example.elastic.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {

    public EmpleadoDTO save(EmpleadoDTO empleadoDTO);

    public List<EmpleadoDTO> list();

}
