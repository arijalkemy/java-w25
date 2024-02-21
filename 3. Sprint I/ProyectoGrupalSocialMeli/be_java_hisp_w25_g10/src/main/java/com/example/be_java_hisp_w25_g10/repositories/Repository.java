package com.example.be_java_hisp_w25_g10.repositories;


import com.example.be_java_hisp_w25_g10.entities.Follower;
import com.example.be_java_hisp_w25_g10.entities.Post;
import com.example.be_java_hisp_w25_g10.entities.RolEnum;
import com.example.be_java_hisp_w25_g10.entities.User;

import com.example.be_java_hisp_w25_g10.entities.*;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


@org.springframework.stereotype.Repository
public class Repository implements IRepository {


    List<Follower> followers;
    List<Post> posts ;
    List<User> users;

    public Repository() {
        Follower[] follows = {
                new Follower(1, 2),
                new Follower(3, 2),
                new Follower(4, 1),
                new Follower(3, 1)
        };

        followers = new ArrayList<>(Arrays.asList(follows));

        User[] usersArray = {
                new User(1, "user1", "lastName", RolEnum.SELLER),
                new User(2, "user2", "lastName", RolEnum.SELLER),
                new User(3, "user3", "lastName", RolEnum.BUYER),
                new User(4, "user4", "lastName", RolEnum.BUYER),
        };

        users = new ArrayList<>(Arrays.asList(usersArray));

        posts = new ArrayList<>(Arrays.asList(new Post[]{
                new Post(1,
                        users.stream().filter(u -> u.getId() == 1).findFirst().get(),
                        LocalDate.now(),
                        new Product(1,
                                123,
                                29.99,
                                "Producto1",
                                "Electrónico",
                                "MarcaA",
                                "Rojo",
                                "Notas sobre el producto",
                                2.5,
                                true

                        )
                ),
                new Post(2,
                        users.stream().filter(u -> u.getId() == 1).findFirst().get(),
                        LocalDate.now().minusDays(19),
                        new Product(1,
                                123,
                                29.99,
                                "Producto2",
                                "Tecnología",
                                "MarcaB",
                                "Amarillo",
                                "Notas sobre el producto",
                                4.0,
                                true
                        )
                ),
                new Post(3,
                        users.stream().filter(u -> u.getId() == 2).findFirst().get(),
                        LocalDate.now().minusDays(19),
                        new Product(1,
                                123,
                                29.99,
                                "Producto3",
                                "Hogar",
                                "MarcaC",
                                "Azul",
                                "Notas sobre el producto",
                                0.0,
                                false
                        )
                )
        }));

    }



    @Override
    public List<Post> getPosts() {
        return null;
    }

    @Override
    public Optional<Follower> follow(int userId, int followedId) {

        Optional<User> follower = findUser(userId);
        Optional<User> followed = findUser(followedId);

        if (follower.isEmpty() || followed.isEmpty() || followed.get().getRole().equals(RolEnum.BUYER))
            return Optional.empty();

        Optional<Follower> relation = followers.stream().filter(follow -> follow.getIdFollower() == userId
                && follow.getIdFollowed() == followedId).findFirst();

        if (relation.isPresent())
            return relation;

        Follower newFollowing = new Follower(userId, followedId);

        followers.add(newFollowing);

        return Optional.of(newFollowing);
    }

    @Override
    public Optional<User> findUser(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public void unFollow(int userId, int followedId) {
        followers.removeIf(follower -> follower.getIdFollower() == userId &&
                follower.getIdFollowed() == followedId);
    }
    public List<User> getFollowersList(int userId) {
        List<Integer> followersList = this.followers.stream()
                .filter(follower -> follower.getIdFollowed() == userId)
                .map(Follower::getIdFollower).toList();
        return this.users.stream()
                .filter(user -> followersList.stream().anyMatch(follower -> follower == user.getId()))
                .toList();
    }

    public List<User> getFollowedList(int userId) {
        List<Integer> followedList = this.followers.stream()
                .filter(follower -> follower.getIdFollower() == userId)
                .map(Follower::getIdFollowed).toList();
        return this.users.stream()
                .filter(user -> followedList.stream().anyMatch(follower -> follower == user.getId()))
                .toList();
    }



    public List<Post> getFollowedPosts(int userId, String sortOrder) {
        List<Integer> followedList = this.followers.stream()
                .filter(follower -> follower.getIdFollower() == userId)
                .map(Follower::getIdFollowed).toList();
        return this.posts.stream()
                .filter(post -> followedList.stream().anyMatch(follower -> follower == post.getUser().getId()))
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusDays(20)))
                .toList();
    }
    @Override
    public Post addPost(Post newPost) {
        posts.add(newPost);
        return newPost;
    }

    @Override
    public List<Post> verPost() {
        return posts;
    }
    @Override
    public List<User>  getSellers(){
        List<User> sellers = new ArrayList<>();
        for (User u: users){
            if (u.getRole().equals("SELLER")){
                sellers.add(u);
            }
        }

        return sellers;
    }
    @Override
    public boolean validatePost (int id ){
        boolean  answer=FALSE;
        //validaciones POST

        //validar si existe el usuario
        for (User u: users){
            if(u.getId()==id ){
                answer=TRUE;
            }
        }
        //validar si el usuario es vendedor


        //validar si el proudcucto ya existe


        //validar fecha


        return answer;
    }
}

