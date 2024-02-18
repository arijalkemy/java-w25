package org.blog.service;

import org.blog.dto.response.EntradaBlogDTO;
import org.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaService {
    void createBlogEntry(EntradaBlog newBlogEntry);
    EntradaBlogDTO getBlogEntryById(Long id);
    List<EntradaBlogDTO> getAllBlogEntries();
}
