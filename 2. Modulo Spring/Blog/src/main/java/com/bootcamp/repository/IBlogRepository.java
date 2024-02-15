package com.bootcamp.repository;

import com.bootcamp.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog create(Blog blog);

    Blog findById(Integer id);

    List<Blog> findAll();
}
