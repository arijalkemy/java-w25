package com.bootcamp.ejercicio_blog.repository;

import com.bootcamp.ejercicio_blog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    public void add(EntradaBlog entradaBlog);
    public Optional<EntradaBlog> getById(int id);
    public List<EntradaBlog> getAll();
}
