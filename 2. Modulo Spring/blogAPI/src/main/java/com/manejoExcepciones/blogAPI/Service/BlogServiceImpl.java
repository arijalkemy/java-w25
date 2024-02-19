package com.manejoExcepciones.blogAPI.Service;

import com.manejoExcepciones.blogAPI.DTOs.BlogRequestDTO;
import com.manejoExcepciones.blogAPI.DTOs.BlogResponseDTO;
import com.manejoExcepciones.blogAPI.Model.EntradaBlog;
import com.manejoExcepciones.blogAPI.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public boolean addBlog(BlogRequestDTO blogRequestDTO) {
        if(blogRepository.existsBlog(blogRequestDTO.getId())){
            return false;
        }
        EntradaBlog blog = new EntradaBlog(blogRequestDTO.getId(),
                blogRequestDTO.getTitulo(),
                blogRequestDTO.getNombreAutor(),
                LocalDate.now().toString());
        return blogRepository.addBlog(blog);
    }

    @Override
    public BlogResponseDTO getBlog(Integer id) {
        Optional<EntradaBlog> blog = blogRepository.getBlog(id);
        if(blog.isEmpty()){
            return null;
        }
        return new BlogResponseDTO(blog.get().getTitulo(),blog.get().getNombreAutor(),blog.get().getFechaPublicacion());
    }

    @Override
    public List<BlogResponseDTO> getBlogs() {
        List<EntradaBlog> blogs = blogRepository.getBlogs();
        List<BlogResponseDTO> blogsResponse = new ArrayList<>();
        for (EntradaBlog blog:
             blogs) {
            blogsResponse.add(new BlogResponseDTO(blog.getTitulo(),blog.getNombreAutor(),blog.getFechaPublicacion()));
        }
        return blogsResponse;
    }
}
