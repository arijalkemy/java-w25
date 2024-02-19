package com.example.youtuber.service;

import com.example.youtuber.dto.EntradaBlogDto;

import java.util.List;


public interface IYoutuberService {
    public EntradaBlogDto addBlog(EntradaBlogDto blog);

    public List<EntradaBlogDto> getAllBlogs();

    public EntradaBlogDto getById(int id);
}
