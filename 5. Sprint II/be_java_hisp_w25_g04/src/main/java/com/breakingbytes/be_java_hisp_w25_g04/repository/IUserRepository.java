package com.breakingbytes.be_java_hisp_w25_g04.repository;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    void setUserFollowings(Integer userId, List<Seller> userFollowings);
    List<User> findAll();
    Optional<User> findById(Integer userId);
    void addFollowing(User user, Seller following);
}
