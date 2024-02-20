package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;

import java.util.Comparator;
import java.util.List;

public class OrderBy {
    public static List<User> orderByUserAsc(List<User> listUsers){
        return listUsers.stream()
                .sorted(Comparator.comparing(User::getUserName))
                .toList();
    }
    public static List<User> orderByUserDes(List<User> listUsers){
        return listUsers.stream()
                .sorted((x,y)->y.getUserName().compareTo(x.getUserName()))
                .toList();
    }
    public static List<Post> orderByDateAsc(List<Post> listPosts){
        return listPosts.stream()
                .sorted(Comparator.comparing(Post::getDate))
                .toList();
    }
    public static List<Post> orderByDateDes(List<Post> listPosts){
        return listPosts.stream()
                .sorted((x,y)->y.getDate().compareTo(x.getDate()))
                .toList();
    }
}
