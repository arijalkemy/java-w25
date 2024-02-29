package com.breakingbytes.be_java_hisp_w25_g04.repository;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    @Override
    public void setUserFollowings(Integer userId, List<Seller> userFollowings) {
        DbMock
            .getInstance()
            .getListOfUsers()
            .stream()
            .filter(u -> u.getId() == userId)
            .findFirst()
            .get()
            .setFollowing(userFollowings);
    }

    @Override
    public List<User> findAll() {
        return DbMock.getInstance().getListOfUsers();
    }


    @Override
    public Optional<User> findById(Integer userId) {
        return DbMock
                .getInstance()
                .getListOfUsers()
                .stream()
                .filter(u -> Objects.equals(u.getId(), userId))
                .findFirst();
    }

    @Override
    public void addFollowing(User user, Seller following) {
        user.addFollowing(following);
    }

}
