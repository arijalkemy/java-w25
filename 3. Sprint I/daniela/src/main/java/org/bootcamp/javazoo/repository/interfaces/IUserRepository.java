package org.bootcamp.javazoo.repository.interfaces;

import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;

import java.util.List;

public interface IUserRepository {
    User getById(Integer userId);
    void addFollowed(User user, Seller seller);
}
