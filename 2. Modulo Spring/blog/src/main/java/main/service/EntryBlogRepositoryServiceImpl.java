package main.service;

import main.dto.ResponseBlogsDTO;
import main.entity.EntryBlog;
import main.exceptions.FoundBlogException;
import main.exceptions.NotFoundException;
import main.repository.IEntryBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryBlogRepositoryServiceImpl implements IEntryBlogService{
    @Autowired
    IEntryBlogRepository entryBlogRepository;

    @Override
    public EntryBlog createBlog(EntryBlog entryBlog) {
        ResponseBlogsDTO blogSearch;

        blogSearch = getAllBlogs().stream().filter(blog -> blog.getId() == entryBlog.getId())
                .findFirst()
                .orElse(null);
        System.out.println(blogSearch);
        if(blogSearch != null){
            throw new FoundBlogException("Ya existe un blog con ese id");
        }
        return entryBlogRepository.addEntryBlog(entryBlog);
    }

    @Override
    public List<ResponseBlogsDTO> getAllBlogs() {
        return entryBlogRepository.getAllEntryBlog().stream()
                .map(entry-> new ResponseBlogsDTO(entry.getId(),entry.getTitle()))
                .toList();
    }

    @Override
    public ResponseBlogsDTO getBlogById(int id) {
        EntryBlog resBlog = entryBlogRepository.getEntryBlogById(id);
        if(resBlog == null)
        {
            throw new NotFoundException("No existe el blog ingresado");
        }
        return new ResponseBlogsDTO(resBlog.getId(), resBlog.getTitle());
    }
}
