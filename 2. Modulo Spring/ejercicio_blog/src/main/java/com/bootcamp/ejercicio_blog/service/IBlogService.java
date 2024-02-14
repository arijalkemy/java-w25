package com.bootcamp.ejercicio_blog.service;

import com.bootcamp.ejercicio_blog.dto.EntradaBlogDTO;

import java.util.List;

public interface IBlogService {
    EntradaBlogDTO getByID(int id);
    List<EntradaBlogDTO> getAll();

    EntradaBlogDTO save(EntradaBlogDTO entradaBlogDTO);
}
