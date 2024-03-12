package com.example.exceptions.service;

import com.example.exceptions.dto.BlogCreationDto;
import com.example.exceptions.dto.BlogDto;
import com.example.exceptions.entity.EntradaBlog;
import com.example.exceptions.exception.AlreadyExistsException;
import com.example.exceptions.exception.NotFoundException;
import com.example.exceptions.repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntradaBlogService {

    private final BlogRepository blogRepository;

    public BlogCreationDto createBlog(EntradaBlog newBlog){
        Integer id =  blogRepository.save(newBlog);
        if (id == null){
            throw new AlreadyExistsException("El id asociado a la entrada de blog ya existe");
        }
        return new BlogCreationDto(id, "El blog se creó exitosamente");
    }

    public BlogDto getBlogById(int id){
        Optional<EntradaBlog> entradaBuscada = blogRepository.getById(id);
        if (entradaBuscada.isEmpty()) {
            throw new NotFoundException("La entrada de blog con ID " + id + " no pudo ser encontrada. Por favor verifique dicho Id");
        }
        return new BlogDto(entradaBuscada.get());
    }

    public List<BlogDto> getAllBlogs(){
        List<EntradaBlog> entradaBlogs = blogRepository.getAllBlogs();
        return entradaBlogs.stream().map(BlogDto::new).toList();
    }
}
