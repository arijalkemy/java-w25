package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository{

    List<Post> posts = new ArrayList<>();
    @Override
    public Post addPost(Post post) {
        posts.add(post);

        return post;
    }

    @Override
    public List<Post> filterByDateAndIdUsuario(Integer idUsuario, LocalDate date) {
        return posts.stream().filter(x -> {
            int dayAct = date.getDayOfMonth();
            int monthAct = date.getMonthValue();
            int yearAct = date.getYear();
            int dayIter = x.getDate().getDayOfMonth();
            int monthIter = x.getDate().getMonthValue();
            int yearIter = x.getDate().getYear();
            if (x.getUser_id().equals(idUsuario) && yearIter <= yearAct && monthIter == monthAct && dayAct-dayIter <= 14) {
                return true;
            }
            return false;
        }).toList();
    }

}
