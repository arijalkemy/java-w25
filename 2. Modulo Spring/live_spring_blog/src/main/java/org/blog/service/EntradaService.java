package org.blog.service;

import org.blog.dto.response.EntradaBlogDTO;
import org.blog.exception.AlreadyExistsException;
import org.blog.exception.NotFoundException;
import org.blog.model.EntradaBlog;
import org.blog.repository.BlogRepositoryImp;
import org.blog.repository.IBlogRepository;
import org.blog.utils.EntradaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaService implements IEntradaService{
    private final IBlogRepository blogRepository;

    @Autowired
    public EntradaService(BlogRepositoryImp blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void createBlogEntry(EntradaBlog newBlogEntry){
        if (blogRepository.getAll().containsKey(newBlogEntry.getId())) {
            throw new AlreadyExistsException("The blog already exists.");
        } else {
            blogRepository.addElement(newBlogEntry);
        }
    }
    @Override
    public EntradaBlogDTO getBlogEntryById(Long id){
        EntradaBlog blogEntry = blogRepository.findById(id);
        if(blogEntry == null){
            throw new NotFoundException("Blog entry with id: " + id + " not found.");
        }
        return EntradaMapper.toDTO(blogEntry);
    }
    @Override
    public List<EntradaBlogDTO> getAllBlogEntries(){
        List<EntradaBlog> blogEntries = new ArrayList<>(blogRepository.getAll().values());
        if(blogEntries == null || blogEntries.isEmpty()){
            throw new NotFoundException("No blog entries found.");
        }
        return blogEntries.stream().map(EntradaMapper::toDTO).toList();
    }
}
