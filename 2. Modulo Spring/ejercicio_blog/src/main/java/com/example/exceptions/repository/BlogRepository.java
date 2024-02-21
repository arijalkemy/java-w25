package com.example.exceptions.repository;

import com.example.exceptions.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository {
    List<EntradaBlog> blogBd = new ArrayList<>();

    public Integer save(EntradaBlog entradaBlog){
        if (blogBd.stream().noneMatch(entradaBlog1 -> entradaBlog1.getId() == (entradaBlog.getId()))){
            blogBd.add(entradaBlog);
            return entradaBlog.getId();
        }
        return null;
    }

    public Optional<EntradaBlog> getById(int id){
        return blogBd.stream().filter(entradaBlog -> entradaBlog.getId() == id).findFirst();
    }
    public  List<EntradaBlog> getAllBlogs(){
        return blogBd;
    }
}
