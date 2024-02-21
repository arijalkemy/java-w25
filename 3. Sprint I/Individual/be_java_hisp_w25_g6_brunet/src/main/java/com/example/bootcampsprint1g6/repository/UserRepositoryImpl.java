package com.example.bootcampsprint1g6.repository;

import com.example.bootcampsprint1g6.entity.Buyer;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.*;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private List<User> users = new ArrayList<>(){{
        add(new Seller(1, "seller1", "seller1@test.com"));
        add(new Seller(2, "seller2", "seller2@test.com"));
        add(new Seller(3, "seller3", "seller3@test.com"));
        add(new Buyer(4, "buyer1", "buyer1@test.com"));
        add(new Buyer(5, "buyer2", "buyer2@test.com"));
        add(new Buyer(6, "buyer3", "buyer3@test.com"));
    }};

    private static Integer index = 0;

    @Override
    public List<User> findAll(){
        return users;
    };
    @Override
    public User save(User user){
        user.setUserId(index);
        users.add(user);
        ++index;
        return user;
    };

    @Override
    public Optional<User> findById(Integer id){
        return users.stream().filter(u->u.getUserId().equals(id)).findFirst();
    }

    @Override
    public List<Seller> getFollowedList(Integer userId) {
        Seller seller = (Seller) users.stream().filter(u -> Objects.equals(u.getUserId(), userId)).findFirst().get();
        return seller.getFollowed();
    }
  
    @Override
    public List<User> getFollowersList(Integer userId) {
        Seller seller = (Seller) users.stream().filter(u -> Objects.equals(u.getUserId(), userId)).findFirst().get();
        return seller.getFollowers();

    }

    public User addPostToUser(Post post){
        Seller seller = (Seller)findById(post.getSeller().getUserId()).get();
        seller.addPost(post);
        return seller;
    }
}
