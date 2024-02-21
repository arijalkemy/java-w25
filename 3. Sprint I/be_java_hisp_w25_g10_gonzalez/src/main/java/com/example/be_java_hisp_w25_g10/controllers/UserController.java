package com.example.be_java_hisp_w25_g10.controllers;

import com.example.be_java_hisp_w25_g10.dtos.CountDto;
import com.example.be_java_hisp_w25_g10.entities.User;
import com.example.be_java_hisp_w25_g10.services.users.IUserService;
import com.example.be_java_hisp_w25_g10.services.users.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    public IUserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/followers/list")
    public List<User> getFollowersList(@PathVariable int userId, @RequestParam(required = false) String sortOrder) {
        return this.userService.getFollowersList(userId, sortOrder);
    }

    @GetMapping("/users/{userId}/followed/list")
    public List<User> getFollowedList(@PathVariable int userId, @RequestParam(required = false) String sortOrder) {
        return this.userService.getFollowedList(userId, sortOrder);
    }
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable("userId") int userId, @PathVariable("userIdToFollow") int toFollowId) {
        userService.follow(userId,toFollowId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unFollow(@PathVariable("userId") int userId, @PathVariable("userIdToUnfollow") int toUnfollowId) {
        userService.unFollow(userId,toUnfollowId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public CountDto getFollowersNumber(@PathVariable int userId) {
        return this.userService.getFollowersNumber(userId);
    }
}
