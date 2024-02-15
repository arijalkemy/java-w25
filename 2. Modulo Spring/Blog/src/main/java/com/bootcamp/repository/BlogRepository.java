package com.bootcamp.repository;

import com.bootcamp.entity.Blog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{

    public HashMap<Integer, Blog> blogs = new HashMap<>();

    public BlogRepository(){
        this.create(new Blog(
                1,
                "Titulo 1",
                "Autor 1",
                LocalDate.now()
        ));
        this.create(new Blog(
                2,
                "Titulo 2",
                "Autor 2",
                LocalDate.now()
        ));
    }
    @Override
    public Blog create(Blog blog) {
        return this.blogs.putIfAbsent(blog.getId(), blog);
    }

    @Override
    public Blog findById(Integer id) {
        return this.blogs.getOrDefault(id,null);
    }

    @Override
    public List<Blog> findAll() {
        return this.blogs.values().stream().toList();
    }
}
