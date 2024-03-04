package com.example.be_java_hisp_w25_g10.controllers;

import com.example.be_java_hisp_w25_g10.dtos.CountDto;
import com.example.be_java_hisp_w25_g10.entities.User;
import com.example.be_java_hisp_w25_g10.services.users.IUserService;
import com.example.be_java_hisp_w25_g10.services.users.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {

    public IUserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/followers/list")
    public List<User> getFollowersList(@Positive @PathVariable int userId, @RequestParam(required = false) String sortOrder) {
        return this.userService.getFollowersList(userId, sortOrder);
    }

    @GetMapping("/users/{userId}/followed/list")
    public List<User> getFollowedList(@Positive @PathVariable int userId, @RequestParam(required = false) String sortOrder) {
        return this.userService.getFollowedList(userId, sortOrder);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@Positive  @PathVariable("userId") int userId,@Positive @PathVariable("userIdToFollow") int toFollowId) {
        userService.follow(userId,toFollowId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unFollow(@Positive @PathVariable("userId") int userId,@Positive @PathVariable("userIdToUnfollow") int toUnfollowId) {
        userService.unFollow(userId,toUnfollowId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public CountDto getFollowersNumber(@Positive @PathVariable int userId) {

        return this.userService.getFollowersNumber(userId);
    }
}
