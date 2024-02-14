package org.example.ejercicio_exceptions.repository;

import org.example.ejercicio_exceptions.entity.BlogEntry;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Long save(BlogEntry blogEntry);

    Optional<BlogEntry> findById(Long id);

    List<BlogEntry> findAll();
}
