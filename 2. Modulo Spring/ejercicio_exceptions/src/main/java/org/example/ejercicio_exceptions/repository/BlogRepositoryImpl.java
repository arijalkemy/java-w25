package org.example.ejercicio_exceptions.repository;

import org.example.ejercicio_exceptions.entity.BlogEntry;
import org.example.ejercicio_exceptions.exception.UniqueIdConstraintException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    private Map<Long, BlogEntry> blogEntries = new HashMap<>();

    @Override
    public Long save(BlogEntry blogEntry) {
        if(blogEntries.containsKey(blogEntry.getId()))
            throw new UniqueIdConstraintException("Ya existe el id " + blogEntry.getId());
        blogEntries.put(blogEntry.getId(), blogEntry);
        return blogEntry.getId();
    }

    @Override
    public Optional<BlogEntry> findById(Long id) {
        return Optional.ofNullable(blogEntries.get(id));
    }

    @Override
    public List<BlogEntry> findAll() {
        return blogEntries.values().stream().toList();
    }


}
