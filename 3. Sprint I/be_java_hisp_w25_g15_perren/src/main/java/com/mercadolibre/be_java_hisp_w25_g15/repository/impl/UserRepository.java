package com.mercadolibre.be_java_hisp_w25_g15.repository.impl;

import com.mercadolibre.be_java_hisp_w25_g15.model.Buyer;
import com.mercadolibre.be_java_hisp_w25_g15.model.Seller;
import com.mercadolibre.be_java_hisp_w25_g15.model.User;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    List<User> users = new ArrayList<>(
            List.of(
                Seller.builder().id(1).username("Tony Stark").followed(new ArrayList<>()).followers(new ArrayList<>()).build(),
                Seller.builder().id(2).username("Luca").followed(new ArrayList<>()).followers(new ArrayList<>()).build(),
                Seller.builder().id(3).username("Martin").followed(new ArrayList<>()).followers(new ArrayList<>()).build(),
                Buyer.builder().id(4).username("Santiago").followed(new ArrayList<>(
                )).build(),
                Buyer.builder().id(5).username("Orlando").followed(new ArrayList<>()).build(),
                Buyer.builder().id(6).username("Miguel").followed(new ArrayList<>()).build(),
                Buyer.builder().id(7).username("Samuel").followed(new ArrayList<>()).build(),
                Buyer.builder().id(8).username("Tony Stark").followed(new ArrayList<>()).build()
            )
    );

    @Override
    public void updateFollowedList(User user) {
        User existingUser = getUserById(user.getId()).get();
        existingUser.setFollowed(existingUser.getFollowed());
    }

    @Override
    public void updateFollowerList(User user) {
        Seller existingSeller = (Seller) getUserById(user.getId()).get();
        existingSeller.setFollowers(((Seller) user).getFollowers());
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return this.users.stream().filter(user -> user.getId() == userId).findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }
}
