package com.practicaIntegradora.exception.service;

import com.practicaIntegradora.exception.dto.EntradaBlogDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEntradaBlogService {
    public EntradaBlogDTO createBlog(EntradaBlogDTO entrada);
    public EntradaBlogDTO getById(int id);
    public List<EntradaBlogDTO> getAll();
}
