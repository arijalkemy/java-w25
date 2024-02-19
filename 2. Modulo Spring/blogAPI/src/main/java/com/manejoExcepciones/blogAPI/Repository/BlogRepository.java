package com.manejoExcepciones.blogAPI.Repository;

import com.manejoExcepciones.blogAPI.Model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository {

    List<EntradaBlog> blogs;

    public BlogRepository() {
        this.blogs = new ArrayList<>();
    }

    public boolean addBlog(EntradaBlog blog){
        return blogs.add(blog);
    }
    public boolean existsBlog(Integer id){
        return blogs.stream()
                .anyMatch(aux -> aux.getId().equals(id));
    }
    public Optional<EntradaBlog> getBlog(Integer id){
        return blogs.stream()
                .filter(aux -> aux.getId().equals(id))
                .findFirst();
    }
    public List<EntradaBlog> getBlogs(){
        return blogs;
    }
}
