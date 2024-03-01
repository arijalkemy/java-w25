package com.example.bootcampsprint1g6.repository.implementation;

import com.example.bootcampsprint1g6.entity.Buyer;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.entity.User;
import com.example.bootcampsprint1g6.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl(){
        List<Buyer> buyers = new ArrayList<>(){{
            add(new Buyer(4, "buyer1", "buyer1@test.com"));
            add(new Buyer(5, "buyer2", "buyer2@test.com"));
            add(new Buyer(6, "buyer3", "buyer3@test.com"));
        }};
        List<Seller> sellers = new ArrayList<>(){{
            add(new Seller(1, "seller1", "seller1@test.com", new ArrayList<>(){{
                add(buyers.get(0));
                add(buyers.get(1));
            }} ));
            add(new Seller(2, "seller2", "seller2@test.com", new ArrayList<>(){{
                add(buyers.get(0));
            }} ));
            add(new Seller(3, "seller3", "seller3@test.com"));
        }};
        buyers.get(0).follow(sellers.get(0));
        buyers.get(0).follow(sellers.get(1));
        buyers.get(1).follow(sellers.get(0));
        this.users.addAll(buyers);
        this.users.addAll(sellers);

    }

    @Override
    public Optional<User> findById(Integer id){
        return users.stream().filter(u->u.getUserId().equals(id)).findFirst();
    }

    @Override
    public List<Seller> getFollowedList(Integer userId) {
        User user = users.stream().filter(u -> Objects.equals(u.getUserId(), userId)).findFirst().get();
        return user.getFollowed();
    }
  
    @Override
    public List<User> getFollowersList(Integer userId) {
        Seller seller = (Seller) users.stream().filter(u -> Objects.equals(u.getUserId(), userId)).findFirst().get();
        return seller.getFollowers();

    }

    public void addPostToUser(Post post){
        Seller seller = (Seller)findById(post.getSeller().getUserId()).get();
        seller.addPost(post);
    }
}
