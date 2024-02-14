package com.example.youtuber.repository;

import com.example.youtuber.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository{

    private List<EntradaBlog> entradaBlogList = new ArrayList<>(){{
        add(new EntradaBlog(1, "Mi primer Blog!", "Tincho youtuber", "10/02/2024"));
        add(new EntradaBlog(2, "¿Cómo ser exitoso en youtube?", "Paulina Coina", "11/02/2024"));
    }};

    @Override
    public List<EntradaBlog> findAll(){
        return this.entradaBlogList;
    };

    @Override
    public EntradaBlog findById(int id) {
        return entradaBlogList.stream()
                .filter(blog -> blog.getIdBlog() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EntradaBlog newEntrada(EntradaBlog entrada){
        entradaBlogList.add(entrada);
        return entrada;
    }


}
