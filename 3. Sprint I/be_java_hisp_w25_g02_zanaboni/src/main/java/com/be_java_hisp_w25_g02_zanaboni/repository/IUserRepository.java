package com.be_java_hisp_w25_g02_zanaboni.repository;

import com.be_java_hisp_w25_g02_zanaboni.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> findById(Integer id);

    List<User> findAll();
}
