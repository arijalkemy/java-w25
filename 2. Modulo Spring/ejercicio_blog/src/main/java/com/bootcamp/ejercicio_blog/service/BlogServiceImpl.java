package com.bootcamp.ejercicio_blog.service;

import com.bootcamp.ejercicio_blog.dto.EntradaBlogDTO;
import com.bootcamp.ejercicio_blog.entity.EntradaBlog;
import com.bootcamp.ejercicio_blog.exception.BadRequestException;
import com.bootcamp.ejercicio_blog.exception.NoContentException;
import com.bootcamp.ejercicio_blog.exception.NotFoundException;
import com.bootcamp.ejercicio_blog.repository.BlogRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BlogServiceImpl implements IBlogService {
    @Autowired
    BlogRepositoryImpl blogRepositoryImpl;
    ObjectMapper mapper = new ObjectMapper();

    public EntradaBlogDTO getByID(int id){
        EntradaBlog entradaBlog = blogRepositoryImpl.getByID(id);
        if (entradaBlog == null){
            throw new NotFoundException("Entrada de blog no encontrada");
        }

        return mapper.convertValue(entradaBlog, EntradaBlogDTO.class);
    };
    public List<EntradaBlogDTO> getAll(){
        List<EntradaBlog> entradaBlogs = blogRepositoryImpl.getAll();
        if(entradaBlogs.isEmpty()){
            throw new NoContentException("Lista vacia");
        }
        return entradaBlogs.stream().map(entradaBlog -> mapper.convertValue(entradaBlog, EntradaBlogDTO.class)).toList();
    };



    public EntradaBlogDTO save(EntradaBlogDTO entradaBlogDTO){

        EntradaBlog entradaBlog = mapper.convertValue(entradaBlogDTO, EntradaBlog.class);
        EntradaBlog result = blogRepositoryImpl.save(entradaBlog);
        if (result == null){
            throw new BadRequestException("Error al crear nuevo blog");
        }
        return entradaBlogDTO;
    }



}
