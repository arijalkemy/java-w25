package com.mercadolibre.be_java_hisp_w25_g15.repository;

import com.mercadolibre.be_java_hisp_w25_g15.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    void updateFollowedList(User user);
    void updateFollowerList(User user);
    Optional<User> getUserById(int userId);
    List<User> getAllUsers();
}
