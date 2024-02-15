package com.bootcamp.service;

import com.bootcamp.dto.BlogDto;
import com.bootcamp.dto.CreatedBlogDto;

import java.util.List;

public interface IBlogService {
    CreatedBlogDto createBlog(BlogDto blogDto);

    BlogDto findById(Integer id);

    List<BlogDto> findAll();
}
