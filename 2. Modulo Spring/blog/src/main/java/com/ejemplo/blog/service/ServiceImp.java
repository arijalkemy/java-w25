package com.ejemplo.blog.service;

import com.ejemplo.blog.dto.EntradaBlogDTO;
import com.ejemplo.blog.dto.ResponseDTO;
import com.ejemplo.blog.exceptions.NotFoundException;
import com.ejemplo.blog.model.EntradaBlog;
import com.ejemplo.blog.respository.IBlogRepository;
import com.ejemplo.blog.util.Mapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImp implements IService{

    @Autowired
    IBlogRepository repository;

    @Override
    public ResponseDTO create(EntradaBlogDTO entradaBlogDTO) {


        return new ResponseDTO(repository.addBlog(Mapeador.convertDTO(entradaBlogDTO), entradaBlogDTO.getId()));
    }

    @Override
    public ResponseDTO getBlog(int id) {
        return Mapeador.converEntity(repository.getData(id), id);
    }

    @Override
    public List<ResponseDTO> getBlogs() {
        if (repository.getAllData().isEmpty()) throw new NotFoundException("No se encontro ningun elemento");
        List<ResponseDTO> list = new ArrayList<>();
        repository.getAllData().forEach((integer, entradaBlog) -> {
            list.add(Mapeador.converEntity(entradaBlog, integer));
        });
        return list;
    }
}
