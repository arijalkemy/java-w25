package com.practicaIntegradora.exception.repository;

import com.practicaIntegradora.exception.dto.EntradaBlogDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEntradaBlogRepository {
    public int createEntrada(EntradaBlogDTO entrada);
    public List<EntradaBlogDTO> getAll();
    public EntradaBlogDTO getById(int id);
}
