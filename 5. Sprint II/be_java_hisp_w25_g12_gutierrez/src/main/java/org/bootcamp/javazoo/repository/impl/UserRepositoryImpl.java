package org.bootcamp.javazoo.repository.impl;

import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        List<Integer> followed = new ArrayList<>();
        followed.add(1);
        User user1 = new User(4, "User 4", followed);
        User user2 = new User(5, "User 5");
        User user3 = new User(6, "User 6");
        List<Integer> followed2 = new ArrayList<>();
        followed2.add(0);
        User user4 = new User(7, "User 7", followed2);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    @Override
    public User getById(Integer userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
    }
}
