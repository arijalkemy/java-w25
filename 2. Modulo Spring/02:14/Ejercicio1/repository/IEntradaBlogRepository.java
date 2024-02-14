package com.blog.ejercicio1.repository;

import java.util.List;

import com.blog.ejercicio1.entity.EntradaBlog;

public interface IEntradaBlogRepository {
    public EntradaBlog postEntradaBlog(EntradaBlog entradaBlog);

    public List<EntradaBlog> getAllEntradaBlog();

    public EntradaBlog getEntradaBlogById(Integer id);
}