package com.example.elastic.service;

import com.example.elastic.dto.EmpleadoDTO;
import com.example.elastic.model.Empleado;
import com.example.elastic.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    private IEmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public EmpleadoDTO save (EmpleadoDTO empleadoDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(empleadoRepository.save(mapper.map(empleadoDTO, Empleado.class)), EmpleadoDTO.class);
    }

    @Override
    public List<EmpleadoDTO> list() {
        ModelMapper mapper = new ModelMapper();
        return empleadoRepository.findAll().stream().map(empleado -> mapper.map(empleado, EmpleadoDTO.class)).toList();
    }
}
