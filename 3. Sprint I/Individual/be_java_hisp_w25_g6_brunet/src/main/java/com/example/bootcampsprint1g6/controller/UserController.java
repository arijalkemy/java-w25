package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.FollowedDTO;
import com.example.bootcampsprint1g6.dto.FollowersCountDTO;
import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import com.example.bootcampsprint1g6.service.IUserService;
import com.example.bootcampsprint1g6.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/users")
@RestController
public class UserController {

    private IUserService userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;

    }
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<GenericResponseDTO> follow(
        @PathVariable Integer userId,
        @PathVariable Integer userIdToFollow
    ) {
        return ResponseEntity.ok(userService.follow(userId, userIdToFollow));
    }
    @PostMapping("/{userId}/unfollow/{userIdToFollow}")
    public ResponseEntity<GenericResponseDTO> unfollow(
        @PathVariable Integer userId,
        @PathVariable Integer userIdToFollow
    ) {
        return ResponseEntity.ok(userService.unfollow(userId, userIdToFollow));
    }


    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowedList(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ){
        return ResponseEntity.ok(userService.getFollowedList(userId, order));
    }
  
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(
        @PathVariable Integer userId
    ) {
        return new ResponseEntity<>(userService.getFollowersCount(userId),HttpStatus.OK);
    }
    

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ){
        return ResponseEntity.ok(userService.getFollowersList(userId, order));
    }
}

