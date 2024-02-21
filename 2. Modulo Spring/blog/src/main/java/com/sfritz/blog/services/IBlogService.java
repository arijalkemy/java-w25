package com.sfritz.blog.services;

import java.util.List;

import com.sfritz.blog.dtos.BlogDto;

public interface IBlogService {

    BlogDto createBlog(BlogDto blogDto);
    BlogDto getBlogById(Integer id);
    List<BlogDto> getAllBlogs();
}
