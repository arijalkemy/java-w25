package com.bootcamp.be_java_hisp_w25_g14_Lozano.service;

import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.ProductPromoCountDto;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.entity.User;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.exceptions.NotSellerException;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.utils.ApiMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


import java.util.List;

@Service
public class UserServiceImp implements IUserService {

    private IUserRepo userRepo;
    private IPostRepo postRepository;

    public UserServiceImp(IUserRepo userRepo,IPostRepo postRepository) {
        this.userRepo = userRepo;
        this.postRepository = postRepository;
    }



    public FollowedListResponseDto listSellersFollowers(int id,String order){
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
}
