package com.practica.elastic.service;

import com.practica.elastic.domain.Obras;
import com.practica.elastic.dto.MessageDTO;
import com.practica.elastic.dto.ObrasDTO;
import com.practica.elastic.respository.IObrasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ObrasServiceImpl implements IObrasService{

    @Autowired
    IObrasRepository repository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public MessageDTO crearObra(ObrasDTO obrasDTO) {

        repository.save(mapper.map(obrasDTO, Obras.class));
        return new MessageDTO("Exitoso");
    }

    @Override
    public List<ObrasDTO> getAll() {

        return repository.findAll().stream()
                .map(obras -> mapper.map(obras, ObrasDTO.class))
                .toList();
    }

    @Override
    public List<ObrasDTO> findByDate(LocalDate date) {
        return repository.findByPublicacionBefore(date).stream()
                .map(obras -> mapper.map(obras, ObrasDTO.class))
                .toList();
    }

    @Override
    public List<ObrasDTO> findByPage() {
        return repository.findTop5ByOrderByNumeroPaginasDesc().stream()
                .map(obras -> mapper.map(obras, ObrasDTO.class))
                .toList();
    }

    @Override
    public List<ObrasDTO> findByEditorial(String editorial) {
        return repository.findByEditorial(editorial).stream()
                .map(obras -> mapper.map(obras, ObrasDTO.class))
                .toList();
    }

    @Override
    public List<ObrasDTO> findByAutor(String autor) {
        return repository.findByAutor(autor).stream()
                .map(obras -> mapper.map(obras, ObrasDTO.class))
                .toList();
    }

    @Override
    public List<ObrasDTO> findByName(String name) {
        return repository.findByNameLike(name).stream()
                .map(obras -> mapper.map(obras, ObrasDTO.class))
                .toList();
    }
}
