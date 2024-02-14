package org.blog.repository;

import org.blog.model.EntradaBlog;

import java.util.Map;

public interface IBlogRepository {
    Map<Long, EntradaBlog> getAll();
    EntradaBlog findById(Long id);
    void  addElement(EntradaBlog entry);
}
