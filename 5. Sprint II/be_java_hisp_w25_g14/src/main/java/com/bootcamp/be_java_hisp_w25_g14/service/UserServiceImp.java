package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.InvalidRequestException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {

    private IUserRepo userRepo;

    public UserServiceImp(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public FollowedListResponseDto listSellersFollowers(int id,String order){

        if(order!=null && !(order.equals("name_asc") || order.equals("name_desc")))
            throw new InvalidRequestException("The order parameter should be name_asc or name_desc.");

        Optional<User> userFollower = userRepo.findUserById(id);

        if (userFollower.isEmpty()) throw new NotFoundException("The user does not exists");

        List<User> followers = userRepo.listSellersFollowers(id);

        if(followers.isEmpty()) throw new NotFoundException("The user does not have followers");
        else followers = sortByName(order,followers);

        return ApiMapper.listSellersFollowers(userFollower.get(),followers);
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
    public FollowedListResponseDto getFollowedByUser(Integer userId, String order){
        List<UserDataDto> followedUsers = new ArrayList<>();
        List<User> followedUsr = new ArrayList<>();
        Optional<User> user = this.userRepo.findUserById(userId);
        if (user.isEmpty()) throw new NotFoundException("The user does not exists");
        List<UserDataDto> userFollowed = this.userRepo.getFollowed(userId);
        for(UserDataDto usr : userFollowed){
            User userEn = ApiMapper.converDtoToUser(usr);
            followedUsr.add(userEn);
        }
        followedUsr = sortByName(order,followedUsr);
        for(User followed : followedUsr){
            UserDataDto followedUserDto = new UserDataDto(followed.getUserId(),followed.getUserName());
            followedUsers.add(followedUserDto);
        }

        return user.map(value -> new FollowedListResponseDto(
                value.getUserId(),
                value.getUserName(),
                followedUsers
        )).orElse(null);
    }

    private List<User> sortByName(String sorted, List<User> users){
        if(sorted!=null && !(sorted.equalsIgnoreCase("name_asc") || sorted.equalsIgnoreCase("name_desc")))
            throw new InvalidRequestException("The order parameter should be either name_asc or name_desc.");
        else{
            if (sorted!=null && sorted.equalsIgnoreCase("name_asc"))
                return users.stream().sorted(Comparator.comparing(User::getUserName)).toList();
            if(sorted!=null && sorted.equalsIgnoreCase("name_desc"))
                return users.stream().sorted(Comparator.comparing(User::getUserName).reversed()).toList();
        }
        return null;
    }
}
