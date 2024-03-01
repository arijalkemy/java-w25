package com.example.bootcampsprint1g6.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Buyer extends User {

    public Buyer(Integer userId, String userName, String email) {
        super(userId, userName, email);
    }

    @Override
    public void follow(Seller seller){
        followed.add(seller);
        seller.addFollower(this);
    }
    @Override
    public void unfollow(Seller seller){
        this.followed.remove(seller);
        seller.removeFollower(this);
    }
}
