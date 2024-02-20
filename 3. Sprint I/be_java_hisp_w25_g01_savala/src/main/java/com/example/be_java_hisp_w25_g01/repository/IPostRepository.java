package com.example.be_java_hisp_w25_g01.repository;

import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.entity.Product;
import com.example.be_java_hisp_w25_g01.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface IPostRepository {
    public List<Post> getAll();
    public Optional<Post> findById(Integer id);
    public List<Post> findByUser(Integer id);
    public void addPost(Post post);
    public Integer generateId();



}
