package com.mercadolibre.be_java_hisp_w25_g15.repository;

import com.mercadolibre.be_java_hisp_w25_g15.model.Buyer;
import com.mercadolibre.be_java_hisp_w25_g15.model.Seller;
import com.mercadolibre.be_java_hisp_w25_g15.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    boolean removeFollower(Seller seller, User user);
    boolean removeFollowed(User user, Seller seller);

    boolean addFollower(Seller seller, User user);
    boolean addFollowed(User user, Seller seller);

    Optional<User> getUserById(Integer userId);
    List<User>getAllUsers();
}
