package com.bootcamp.be_java_hisp_w25_g9.repository.interfaces;

import com.bootcamp.be_java_hisp_w25_g9.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    String addUser(User user);

    List<User> findAll();
    boolean userExists(long userId);
    User getUserById(long userId);
    void save(User user);
    User getUserById(Integer id);
}
