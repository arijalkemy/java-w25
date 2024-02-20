package main.repository;

import main.entity.EntryBlog;

import java.util.List;

public interface IEntryBlogRepository {

    EntryBlog addEntryBlog(EntryBlog enty);
    EntryBlog getEntryBlogById(int id);
    List<EntryBlog> getAllEntryBlog();
}
