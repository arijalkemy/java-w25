package com.example.youtuber.service;

import com.example.youtuber.dto.EntradaBlogDTO;
import com.example.youtuber.dto.GenericResponseDTO;

import java.util.List;

public interface IEntradaBlogService {
    public GenericResponseDTO savePost(EntradaBlogDTO entradaBlogDTO);
    public EntradaBlogDTO findById(int id);
    public List<EntradaBlogDTO> findAll();
}
