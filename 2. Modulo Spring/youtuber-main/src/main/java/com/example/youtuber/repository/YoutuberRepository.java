package com.example.youtuber.repository;

import com.example.youtuber.entities.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class YoutuberRepository implements  IRepository {

    public Map<Integer, EntradaBlog> blogs = new HashMap<>();

    public List<EntradaBlog> getAll(){
        return List.copyOf(blogs.values());
    }

    public EntradaBlog getEntradaBlogById(int id){
        return blogs.get(id);
    }

    public EntradaBlog addEntradaBlog(EntradaBlog blog){
        blogs.put(blog.getId(), blog);
        return getEntradaBlogById(blog.getId());
    }

}
