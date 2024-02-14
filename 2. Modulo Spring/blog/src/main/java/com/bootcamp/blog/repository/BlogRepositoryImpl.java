package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    private List<EntradaBlog> entradas = new ArrayList<>();

    public BlogRepositoryImpl(){
        loadData(); //llama load data para agregar blogs X
    }

    public void  loadData(){
        this.entradas.add(new EntradaBlog(
                1,
                "Programacion Basica",
                "Hackerman",
                "2024-02-14"
        ));
        this.entradas.add(new EntradaBlog(
                2,
                "Programacion Avanzada",
                "Hackerman",
                "2024-02-15"
        ));
    }
    @Override
    public EntradaBlog findById(int id){
        Optional<EntradaBlog> opt = this.entradas.stream()
                .filter(blog -> blog.getId() == id).findFirst();
        if(!opt.isPresent()) return null;
        return opt.get();
    }
    @Override
    public Integer save(EntradaBlog newBlog){
        long i = this.entradas.stream().filter(blog -> blog.getId() == newBlog.getId()).count();
        if(i > 0) return null;
        this.entradas.add(newBlog);
        return newBlog.getId();
    }

    @Override
    public List<EntradaBlog> findAll(){
        return this.entradas;
    }

}
