package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.SellerAvgPriceDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.dto.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotSellerException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.PostRepoImp;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


import java.util.List;

@Service
public class UserServiceImp implements IUserService {

    private final IUserRepo userRepo;
    private final IPostRepo postRepo;

    public UserServiceImp(IUserRepo userRepo, PostRepoImp postRepoImp) {
        this.userRepo = userRepo;
        this.postRepo = postRepoImp;
    }

    public FollowedListResponseDto listSellersFollowers(int id, String order){
        Optional<User> userFollower = userRepo.findUserById(id);

        if (userFollower.isEmpty()) throw new NotFoundException("The user does not exists");

        if(!userFollower.get().getIsSeller()) throw new NotSellerException("the user is not a seller");

        return ApiMapper.listSellersFollowers(userFollower.get(),userRepo.listSellersFollowers(id,order));
    }

    @Override
    public void addFollowe(Integer userId, Integer userIdToFollow) {
        this.userRepo.addFollower(userId, userIdToFollow);
    }

    @Override    public void removeFollow(Integer userId, Integer userIdToUnfollow) {
        this.userRepo.removeFollow(userId, userIdToUnfollow);
    }

    @Override
    public UserFollowersCountDto getUserFollowersCount(Integer userId) {
        Optional<User> optionalUser = userRepo.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (!user.getIsSeller())
                throw new FollowException("The user is not a seller");
            int followersCount = user.getFollowers().size();
            return new UserFollowersCountDto(userId, user.getUserName(), followersCount);
        } else {
            throw new NotFoundException("User not found");
        }

    }

    @Override
    public FollowedListResponseDto getFollowedByUser(Integer userId){
        List<UserDataDto> userFollowed = this.userRepo.getFollowed(userId);
        Optional<User> user = this.userRepo.findUserById(userId);
        return user.map(value -> new FollowedListResponseDto(
                value.getUserId(),
                value.getUserName(),
                userFollowed
        )).orElse(null);
    }

    /*
    Trabajo individual
    -Obtener el precio promedio de los posts de un vendedor
     */
    @Override
    public SellerAvgPriceDto getAvgPriceById(Integer id) {
        /*
            Obtenemos el usuario con su ID y verificamos si existe
         */
        Optional<User> user = userRepo.findUserById(id);
        if(user.isEmpty()) throw new NotFoundException("There is no user with this id");

        /*
            Obtenemos los posts del usuario y verificamos si tiene posts
         */
        List<Post> userPosts = postRepo.getPostsById(id);
        if(userPosts.isEmpty()) throw new NotFoundException("The user has no posts");

        /*
        Obtenemos la cantidad de posts
         */
        Integer postCount = userPosts.size();

        /*
        Obtenemos el promedio de los posts mediante un Stream y lambda
         */
        Double avgPostPrice = userPosts.stream()
                .mapToDouble(Post::getPrice)
                .average()
                .orElse(0.0);

        return new SellerAvgPriceDto(
                id,
                user.get().getUserName(),
                postCount,
                avgPostPrice
        );
    }

}
