package com.ejemplo.blog.respository;

import com.ejemplo.blog.exceptions.NotFoundException;
import com.ejemplo.blog.exceptions.ObjectDuplicateException;
import com.ejemplo.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepositoryImp implements IBlogRepository{

    public Map<Integer, EntradaBlog> blogList = new HashMap<>();
    @Override
    public Integer addBlog(EntradaBlog entradaBlog, int key) {
        if (this.blogList.containsKey(key)) throw new ObjectDuplicateException("Objeto duplicado");
        this.blogList.put(key, entradaBlog);
        return key;
    }

    @Override
    public EntradaBlog getData(int key) {
        if (!this.blogList.containsKey(key)) throw new NotFoundException("Elemento no encontrado");
        return this.blogList.get(key);
    }

    @Override
    public Map<Integer,EntradaBlog> getAllData() {
        return this.blogList;
    }
}
