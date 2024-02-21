package com.bootcamp.be_java_hisp_w25_g02.repository;

import com.bootcamp.be_java_hisp_w25_g02.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> findById(Integer id);


    List<User> findAll();

}
