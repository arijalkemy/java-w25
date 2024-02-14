package com.bootcamp.ejercicio_blog.repository;

import com.bootcamp.ejercicio_blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    EntradaBlog getByID(int id);
    List<EntradaBlog> getAll();

    EntradaBlog save(EntradaBlog entradaBlog);

}
