package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.Blog;
import com.mercadolibre.blog.exception.DuplicateException;
import com.mercadolibre.blog.exception.NoFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepoImp  implements  IBlogRepo<Blog, Integer>{

    Map<Integer, Blog> mapBlog;

    public BlogRepoImp(){
        this.mapBlog = new HashMap<>();
    }
    @Override
    public Map<Integer, Blog> getAll() {
        return this.mapBlog;
    }

    @Override
    public void add(Integer id, Blog blog) {
        if (this.mapBlog.containsKey(id)){
            throw new DuplicateException("Id Already exist");
        }
        else{
            this.mapBlog.put(id, blog);
        }

    }

    @Override
    public Blog getById(Integer id) {
        if (this.mapBlog.containsKey(id)){
            return this.mapBlog.get(id);

        }
        else{
            throw  new NoFoundException("Blog id not found");
        }

    }


}
