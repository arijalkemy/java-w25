package org.example.manejo_de_excepciones_p1_vivo.repository;

import org.example.manejo_de_excepciones_p1_vivo.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface BlogRepositoryInterface {
    void insertNewBlog(EntradaBlog blog);
    Optional<EntradaBlog> findOneBlogById(int id);
    List<EntradaBlog> findAllBlogs();
}
