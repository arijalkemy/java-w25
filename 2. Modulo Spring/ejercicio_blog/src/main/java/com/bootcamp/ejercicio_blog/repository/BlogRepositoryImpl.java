package com.bootcamp.ejercicio_blog.repository;

import com.bootcamp.ejercicio_blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class BlogRepositoryImpl implements IBlogRepository{
    List<EntradaBlog> entradas;
    public BlogRepositoryImpl(){
        entradas = new ArrayList<>();
    }
    @Override
    public EntradaBlog getByID(int id) {
        Optional<EntradaBlog> entrada = this.entradas.stream().filter(entradaBlog -> entradaBlog.getId() == id).findFirst();
        return entrada.orElse(null);
    }

    @Override
    public List<EntradaBlog> getAll() {
       return this.entradas;
    }

    @Override
    public EntradaBlog save(EntradaBlog entradaBlog) {
        Optional<EntradaBlog> entrada = this.entradas.stream().filter(entradaB -> entradaB.getId() == entradaBlog.getId()).findFirst();
        if (entrada.isPresent()){
            return null;
        }else{
            this.entradas.add(entradaBlog);
        }
        return entradaBlog;
    }


}
