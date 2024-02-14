package com.blog.ejercicio1.service;

import java.util.List;

import com.blog.ejercicio1.dto.request.EntradaBlogRequestDTO;
import com.blog.ejercicio1.dto.response.EntradaBlogIdResDTO;
import com.blog.ejercicio1.dto.response.EntradaBlogResponseDTO;

public interface IEntradaBlogService {
    public EntradaBlogIdResDTO postEntradaBlog(EntradaBlogRequestDTO entradaBlogRequestDTO);

    public List<EntradaBlogResponseDTO> getAllEntradaBlog();

    public EntradaBlogResponseDTO getEntradaBlogById(Integer id);

}