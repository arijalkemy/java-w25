package com.be_java_hisp_w25_g02_zanaboni.controller;

import com.be_java_hisp_w25_g02_zanaboni.dto.response.FollowerCountDTO;
import com.be_java_hisp_w25_g02_zanaboni.dto.response.FollowerListDTO;
import com.be_java_hisp_w25_g02_zanaboni.dto.response.UserFollowingDTO;
import com.be_java_hisp_w25_g02_zanaboni.service.IUserService;
import com.be_java_hisp_w25_g02_zanaboni.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UserController {
    private final IUserService userService;

    public UserController(UserServiceImpl userService, IUserService userService1) {
        this.userService = userService1;
    }
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowingDTO> getFollowedSellers(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowedSellers(userId, order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        userService.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/followers")
    public ResponseEntity<?> getFollowersList(@PathVariable Integer userId, @RequestParam(required = false) String order){
        FollowerListDTO followersList = userService.getFollowersList(userId, order);
        return new ResponseEntity<>(followersList, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> getUserTotalFollowers (@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getUserTotalFollowers(userId), HttpStatus.OK);
    }
}
