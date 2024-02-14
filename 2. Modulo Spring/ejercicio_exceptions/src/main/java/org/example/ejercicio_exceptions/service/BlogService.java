package org.example.ejercicio_exceptions.service;

import org.example.ejercicio_exceptions.dto.BlogEntryDTO;
import org.example.ejercicio_exceptions.dto.BlogSaveRequestDTO;
import org.example.ejercicio_exceptions.dto.BlogSavedResponseDTO;
import org.example.ejercicio_exceptions.entity.BlogEntry;
import org.example.ejercicio_exceptions.exception.BlogNotFoundException;
import org.example.ejercicio_exceptions.repository.IBlogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService {
    private IBlogRepository repository;

    public BlogService(IBlogRepository repository) {
        this.repository = repository;
    }

    public BlogSavedResponseDTO saveBlog(BlogSaveRequestDTO blogSaveRequestDTO) {
        BlogEntry blogEntry = blogSaveRequestDtoToBlogEntry(blogSaveRequestDTO);

        repository.save(blogEntry);

        return blogEntryToBlogSaved(blogEntry);
    }

    public BlogEntryDTO findById(Long id) {
        BlogEntry blogEntry = repository.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("No se encontró el blog con el id " + id));

        return blogEntryToBlogEntryDTO(blogEntry);
    }

    public List<BlogEntryDTO> findAll() {
        List<BlogEntry> blogEntries = repository.findAll();

        return blogEntries.stream()
                .map(this::blogEntryToBlogEntryDTO)
                .toList();
    }


    //-------------- mappers! -----------------
    private BlogEntryDTO blogEntryToBlogEntryDTO(BlogEntry blogEntry){
        return new BlogEntryDTO(blogEntry.getId(),
                blogEntry.getTitle(),
                blogEntry.getAuthorName(),
                blogEntry.getDate());
    }
    private BlogEntry blogSaveRequestDtoToBlogEntry(BlogSaveRequestDTO blogSaveRequestDTO){
        return new BlogEntry(blogSaveRequestDTO.getId(),
                blogSaveRequestDTO.getAuthorName(),
                blogSaveRequestDTO.getTitle(),
                LocalDate.now());
    }

    private BlogSavedResponseDTO blogEntryToBlogSaved(BlogEntry blogEntry){
        return new BlogSavedResponseDTO(blogEntry.getId());
    }



}
