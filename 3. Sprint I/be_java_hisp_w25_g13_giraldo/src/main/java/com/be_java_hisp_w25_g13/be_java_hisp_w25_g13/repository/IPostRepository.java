package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;

import java.time.LocalDate;
import java.util.List;


public interface IPostRepository {

    Post addPost(Post post);
    List<Post> filterByDateAndIdUsuario(Integer userId, LocalDate date);

    List<Post> getPostById(Integer userId);

    List<Post> filterByHasPromo(List<Post> posts);

}
