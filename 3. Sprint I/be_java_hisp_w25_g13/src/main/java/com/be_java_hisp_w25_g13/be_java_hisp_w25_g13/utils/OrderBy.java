package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderBy {
    public static List<User> orderByUserAsc(List<User> listUsers){
        List<User> listOrderByAsc =listUsers.stream()
                .sorted(Comparator.comparing(User::getUserName))
                .collect(Collectors.toList());
        return listOrderByAsc;
    }
    public static List<User> orderByUserDes(List<User> listUsers){
        List<User> listOrderByDes = listUsers.stream()
                .sorted((x,y)->y.getUserName().compareTo(x.getUserName()))
                .collect(Collectors.toList());
        return listOrderByDes;
    }

    public static List<Post> orderByDateAsc(List<Post> listPosts){
        List<Post> listOrderByAsc = listPosts.stream()
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList());
        return listOrderByAsc;
    }
    public static List<Post> orderByDateDes(List<Post> listPosts){
        List<Post> listOrderByDes = listPosts.stream()
                .sorted((x,y)->y.getDate().compareTo(x.getDate()))
                .collect(Collectors.toList());
        return listOrderByDes;
    }

}
