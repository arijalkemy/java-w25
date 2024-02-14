package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.request.BlogDTORequest;
import com.bootcamp.blog.dto.response.BlogDTOResponse;

import java.util.List;

public interface IBlogService {

    BlogDTOResponse createBlog(BlogDTORequest blogDTORequest);

    BlogDTOResponse getBlogById(int id);

    List<BlogDTOResponse> findAll();
}
