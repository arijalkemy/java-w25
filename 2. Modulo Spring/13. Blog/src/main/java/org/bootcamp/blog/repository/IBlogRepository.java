package org.bootcamp.blog.repository;

import org.bootcamp.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    List<EntradaBlog> getAll();

    void add(EntradaBlog blog);

    List<EntradaBlog> getById(int id);
}
