package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    User addUser(User user);
    List<User> getAll();
    Optional<User> getUserById(Integer userId);
}
