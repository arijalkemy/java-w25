package com.sfritz.blog.repositories;

import java.util.List;

import com.sfritz.blog.entities.Blog;

public interface IBlogRepository {

    Blog createBlog(Blog blogDto);
    Blog getBlogById(Integer id);
    List<Blog> getAllBlogs();
}
