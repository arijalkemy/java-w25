package com.example.poryectoblog.repository;

import com.example.poryectoblog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository {

    public List<EntradaBlog> getAllEntradaBlog();
    public EntradaBlog getEntradaBlogById(Integer id);
    public EntradaBlog saveEntradaBlog(EntradaBlog entradaBlog);


}
