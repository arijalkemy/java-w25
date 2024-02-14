package com.meli.manejoexcepciones.service.impl;

import com.meli.manejoexcepciones.dto.blog.BlogDTO;
import com.meli.manejoexcepciones.dto.common.ResponseDTO;
import com.meli.manejoexcepciones.entity.Blog;
import com.meli.manejoexcepciones.exception.BlogAlreadyExistsException;
import com.meli.manejoexcepciones.exception.BlogNotFoundException;
import com.meli.manejoexcepciones.repository.IBlogRepository;
import com.meli.manejoexcepciones.service.IBlogService;
import com.meli.manejoexcepciones.util.BlogMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    private IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    @Override
    public ResponseDTO create(BlogDTO blogDTO) {
        Optional<Blog> blog = this.blogRepository.getById(blogDTO.getId());

        if (blog.isPresent()) {
            throw new BlogAlreadyExistsException("El id ya existe");
        }

        Blog createdBlog = this.blogRepository.save(BlogMapper.toBlog(blogDTO));

        return BlogMapper.toResponseDTO(createdBlog, "Blog creado correctamente");
    }

    @Override
    public BlogDTO getById(int id) {
        Optional<Blog> blog = this.blogRepository.getById(id);

        if (blog.isEmpty()) {
            throw new BlogNotFoundException("El id no existe");
        }

        return BlogMapper.toBlogDTO(blog.get());
    }

    @Override
    public List<BlogDTO> getAll() {
        return this.blogRepository.getAll().stream().map(BlogMapper::toBlogDTO).toList();
    }
}