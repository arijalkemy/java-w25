package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;

import java.time.LocalDate;
import java.util.List;


public interface IPostRepository {

    Post addPost(Post post);
    List<Post> filterByDateAndIdUsuario(Integer idUsuario, LocalDate date);
    List<Post> getPromoPosts();

}
