package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.dto.FollowersCountDTO;
import com.example.bootcampsprint1g6.entity.Buyer;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.entity.User;
import java.util.ArrayList;

import java.util.List;

public class UserTestGenerator {

    public static Buyer getBuyerWithId(Integer id) {
        return new Buyer(id, "Fulano", "fulano@mail.com");
    }

    public static Seller getSellerWithId(Integer id) {
        return new Seller(id, "Fulano", "fulano@mail.com");
    }
    public static User getBuyerFollowingSeller(Integer buyerId, Integer sellerId) {
        Buyer buyer = getBuyerWithId(buyerId);
        Seller seller = getSellerWithId(sellerId);
        buyer.follow(seller);

        return buyer;
    }

    public static Seller getSellerFollowedByBuyer(Integer buyerId, Integer sellerId) {
        Seller seller = getSellerWithId(sellerId);
        Buyer buyer = getBuyerWithId(buyerId);

        buyer.follow(seller);

        return seller;
    }
    public static Seller getSellerWithFollowers(Integer id) {
        return new Seller(id, "the seller", "test@seller.com",
                        List.of( new Buyer(34, "pepito", "pepito@rules.com"),
                                 new Buyer(24, "juancito", "juancito@kil.net") ));
    }

    public static FollowersCountDTO getFollowersCountDTOWSeller(Integer id){
        Seller seller = getSellerWithFollowers(id);
        return new FollowersCountDTO(seller.getUserId(), seller.getUserName(), seller.getFollowers().size());
    }

    public static List<User> getFollowersUser(){
        List<User> followedUsers = new ArrayList<>();
        followedUsers.add(new Seller(1, "buyer1", "seller1@test.com"));
        followedUsers.add(new Seller(2, "buyer2", "seller2@test.com"));
        return followedUsers;
    }

}
