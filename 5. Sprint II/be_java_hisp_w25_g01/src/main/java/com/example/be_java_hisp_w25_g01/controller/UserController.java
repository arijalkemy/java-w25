package com.example.be_java_hisp_w25_g01.controller;

import com.example.be_java_hisp_w25_g01.dto.response.FollowedDTO;
import com.example.be_java_hisp_w25_g01.dto.response.FollowersDTO;
import com.example.be_java_hisp_w25_g01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    //US 0001
    @PostMapping("/{UserId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int UserId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.followUser(UserId,userIdToFollow),HttpStatus.OK);
    }


    //US 0002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    };


    //US 0003 Y 0008
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getSellerFollowers(@PathVariable int userId,
                                                                 @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.getFollowersList(userId, order));
    }

    //US 0004 Y 0008
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowedSellers(@PathVariable int userId,
                                                                @RequestParam(required = false) String order) {
        return ResponseEntity.ok (userService.getFollowedList(userId, order));
    }


    //US 0007
    @PostMapping("{UserId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int UserId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<>(userService.unfollowUser(UserId,userIdToUnfollow),HttpStatus.OK);
    };


}
