package com.sfritz.blog.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sfritz.blog.entities.Blog;

@Component
public class DataBase {

    private List<Blog> blogs;

    public DataBase(){
        this.blogs = new ArrayList<>();
    }

    public Blog createBlog(Blog blog){
        this.blogs.add(blog);
        return this.blogs.get(this.blogs.size()-1);
    }

    public Blog getBlogById(Integer id){
        return this.blogs.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Blog> getAllBlogs(){
        return this.blogs;
    }
}
