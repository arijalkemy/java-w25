package com.example.be_java_hisp_w25_g10.services.users;

import com.example.be_java_hisp_w25_g10.dtos.CountDto;
import com.example.be_java_hisp_w25_g10.dtos.FollowedFollowerDto;
import com.example.be_java_hisp_w25_g10.entities.Follower;
import com.example.be_java_hisp_w25_g10.entities.RolEnum;
import com.example.be_java_hisp_w25_g10.entities.User;
import com.example.be_java_hisp_w25_g10.exceptions.InvalidRequestException;
import com.example.be_java_hisp_w25_g10.exceptions.NotFoundException;
import com.example.be_java_hisp_w25_g10.repositories.IRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    IRepository repository;

    public UserService(IRepository repository) {
        this.repository = repository;
    }

    public List<User> getFollowersList(int userId, String sortOrder) {
        //TODO: Make Unit Test
        List<User> followersList = repository.getFollowersList(userId);
        if (sortOrder != null) {
            if (sortOrder.equals("asc")) {
                followersList = followersList.stream()
                        .sorted(Comparator.comparing(User::getName))
                        .collect(Collectors.toList());
            } else if (sortOrder.equals("desc")) {
                followersList = followersList.stream()
                        .sorted(Comparator.comparing(User::getName).reversed())
                        .collect(Collectors.toList());
            }else {
                throw new InvalidRequestException("Invalid sort order: " + sortOrder);
            }
        }
        return followersList;
    }

    public List<User> getFollowedList(int userId, String sortOrder) {
        // TODO: Make Unit Test
        List<User> followedList = repository.getFollowedList(userId);
        if (sortOrder != null) {
            if (sortOrder.equals("asc")) {
                followedList = followedList.stream()
                        .sorted(Comparator.comparing(User::getName))
                        .collect(Collectors.toList());
            } else if (sortOrder.equals("desc")) {
                followedList = followedList.stream()
                        .sorted(Comparator.comparing(User::getName).reversed())
                        .collect(Collectors.toList());
            }else {
                throw new InvalidRequestException("Invalid sort order: " + sortOrder);
            }
        }
        return followedList;
    }

    @Override
    public boolean follow(int userId, int followedId) {

        Optional<User> userToFollow = repository.findUser(followedId);

        if (userToFollow.isEmpty())
            throw new NotFoundException("The user to follow does not exist");

        if (userToFollow.get().getRole().equals(RolEnum.BUYER))
            throw new InvalidRequestException("You can only follow sellers");

        Optional<Follower> follower = repository.follow(userId, followedId);

        if (follower.isEmpty())
            throw new InvalidRequestException("Either one or both users does not exist, or the user to follow is not a seller");

        return true;
    }

    @Override
    public boolean unFollow(int userId, int followedId) {

        Optional<User> userToUnfollow = repository.findUser(followedId);

        if (userToUnfollow.isEmpty())
            throw new NotFoundException("The user to unfollow does not exist");

        repository.unFollow(userId, followedId);

        return true;
    }


}




