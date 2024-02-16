package com.ejemplo.blog.respository;

import com.ejemplo.blog.model.EntradaBlog;

import java.util.List;
import java.util.Map;

public interface IBlogRepository {

    Integer addBlog(EntradaBlog entradaBlog, int key);

    EntradaBlog getData(int key);

    Map<Integer, EntradaBlog> getAllData();
}
