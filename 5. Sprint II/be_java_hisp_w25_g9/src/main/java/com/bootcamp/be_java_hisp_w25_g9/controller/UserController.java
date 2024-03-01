package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.service.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    IUserService service;

    public UserController(IUserService service){
        this.service = service;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){

        return  new ResponseEntity<>(service.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDto> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){

        return new ResponseEntity<>(service.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDto> countFollowers(@PathVariable int userId){

        return  new ResponseEntity<>(service.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDto> getFollowersList(@PathVariable int userId, @RequestParam(value = "order", required = false) String order){
        if (order != null) return new ResponseEntity<>(service.getFollowers(userId, order), HttpStatus.OK);
        return  new ResponseEntity<>(service.getFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDto> getFollowedList(@PathVariable int userId, @RequestParam(value = "order", required = false) String order){
        if (order != null) return new ResponseEntity<>(service.getFollowed(userId, order), HttpStatus.OK);
        return new ResponseEntity<>(service.getFollowed(userId), HttpStatus.OK);
    }
}
