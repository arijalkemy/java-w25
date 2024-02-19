package org.bootcamp.blog.service;

import org.bootcamp.blog.dto.BlogDto;
import org.bootcamp.blog.dto.ResponseDto;

import java.util.List;

public interface IBlogService {
    ResponseDto addBlog(BlogDto blog);

    List<BlogDto> getAllBlogs();

    BlogDto getBlogById(int blogId);
}
