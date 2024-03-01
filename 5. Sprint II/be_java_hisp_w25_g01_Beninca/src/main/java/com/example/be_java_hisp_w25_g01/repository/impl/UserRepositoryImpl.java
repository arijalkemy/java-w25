package com.example.be_java_hisp_w25_g01.repository.impl;

import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.entity.User;
import com.example.be_java_hisp_w25_g01.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class UserRepositoryImpl implements IUserRepository {


    private List<User> userList;
    public UserRepositoryImpl(){
        loadUserList();
    }




    private List<User> loadUserList(){
        userList = new ArrayList<>();
        userList.add(new User(1,"martinMarquez", new ArrayList<>(List.of(5)), new ArrayList<>(List.of()), new ArrayList<>(List.of()) ));
        userList.add(new User(2,"ariJaime", new ArrayList<>(List.of(4,5)), new ArrayList<>(List.of()), new ArrayList<>(List.of())));
        userList.add(new User(3,"ezeEscobar", new ArrayList<>(List.of(4,5)), new ArrayList<>(List.of()), new ArrayList<>(List.of())));
        userList.add(new User(4,"sofiaMaria", new ArrayList<>(List.of(5)), new ArrayList<>(List.of(2,3)),new ArrayList<>(List.of(1,2,5,6)))); // es vendedor
        userList.add(new User(5,"leanSaracco", new ArrayList<>(List.of()), new ArrayList<>(List.of(1,2,3,4)),new ArrayList<>(List.of(4,5))));// es vendedor
        return userList;
    }

    public void createPost(Post post){
        userList.stream()
                .filter(u-> u.getUserId().equals(post.getUser_id()))
                .findFirst()
                .ifPresent(u -> u.getPosts().add(post.getPost_id()));
    }

    public List<User> findAll() { return userList; }

    public Optional<User> findById(Integer userId){

        return userList.stream()
                .filter(u -> Objects.equals(u.getUserId(), userId))
                .findFirst();
    }

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        Optional<User> user = findById(userId);
        Optional<User> userToFollow = findById(userIdToFollow);
        user.get().getFollowed().add(userIdToFollow);
        userToFollow.get().getFollowers().add(userId);
    }
    @Override
    public void unfollowUser(Integer UserId, Integer userIdToUnfollow) {
        Optional<User> user = findById(UserId);
        Optional<User> userToUnfollow = findById(userIdToUnfollow);
        user.get().getFollowed().remove(userIdToUnfollow);
        userToUnfollow.get().getFollowers().remove(UserId);
    }
    @Override
    public List<User> findAllByIdIn(List<Integer> userIds) {
        return userList.stream()
                .filter(user -> userIds.contains(user.getUserId()))
                .collect(Collectors.toList());
    }

}
