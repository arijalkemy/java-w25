package main.service;

import main.dto.RequestBlogDTO;
import main.dto.ResponseBlogsDTO;
import main.entity.EntryBlog;

import java.util.List;

public interface IEntryBlogService {

    EntryBlog createBlog(EntryBlog entryBlog);
    List<ResponseBlogsDTO> getAllBlogs();
    ResponseBlogsDTO getBlogById(int id);
}
