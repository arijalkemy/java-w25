package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.EntradaBlog;
import java.util.List;
public interface IBlogRepository {

    EntradaBlog findById(int id);
    Integer save(EntradaBlog newBlog);
    List<EntradaBlog> findAll();
}
