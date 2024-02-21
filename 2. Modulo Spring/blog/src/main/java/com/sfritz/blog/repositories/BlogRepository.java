package com.sfritz.blog.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sfritz.blog.entities.Blog;
import com.sfritz.blog.util.DataBase;

@Repository
public class BlogRepository implements IBlogRepository{

    private DataBase db;

    public BlogRepository(DataBase db){
        this.db = db;
    }

    @Override
    public Blog createBlog(Blog blog) {
        return this.db.createBlog(blog);
    }

    @Override
    public Blog getBlogById(Integer id) {
        return db.getBlogById(id);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return db.getAllBlogs();
    }

}
