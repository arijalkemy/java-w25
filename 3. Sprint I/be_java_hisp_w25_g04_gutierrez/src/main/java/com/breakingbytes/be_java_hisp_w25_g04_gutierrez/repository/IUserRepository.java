package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.repository;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.User;
import java.util.Optional;
import java.util.List;

public interface IUserRepository {

    void setUserFollowings(Integer userId, List<Seller> userFollowings);
    List<User> findAll();
    Optional<User> findById(int userId);
    void addFollowing(User user, Seller following);
}
