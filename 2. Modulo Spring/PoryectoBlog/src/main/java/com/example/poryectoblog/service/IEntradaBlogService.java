package com.example.poryectoblog.service;

import com.example.poryectoblog.dto.EntradaBlogDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEntradaBlogService {

    ResponseEntity<?> addNewEntradaBlog(EntradaBlogDto entradaBlog);
    EntradaBlogDto getEntradaBlogById(Integer id);
    List<EntradaBlogDto> getAllEntradaBlog();



}
