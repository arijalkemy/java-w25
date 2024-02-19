package org.bootcamp.blog.repository;

import org.bootcamp.blog.exception.DuplicateBlogException;
import org.bootcamp.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    List<EntradaBlog> blogs = new ArrayList<>();
    @Override
    public List<EntradaBlog> getAll(){
        return blogs;
    }
    @Override
    public void add(EntradaBlog blog){
        this.blogs.add(blog);
    }
    @Override
    public List<EntradaBlog> getById(int id){
         return blogs.stream().filter(entradaBlog -> entradaBlog.getId()==id).toList();
    }
}
