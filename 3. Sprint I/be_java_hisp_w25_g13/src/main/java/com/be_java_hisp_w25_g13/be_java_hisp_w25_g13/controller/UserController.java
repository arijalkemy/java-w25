package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.controller;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.FollowersDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.NumberDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.FollowedDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.UserDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        userService.unFollowUser(userId, userIdToUnfollow);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<NumberDTO> getFollowersCount(@PathVariable Integer userId){
        return ResponseEntity.ok().body(userService.getNumberOfFollowers(userId));
    }
    @GetMapping("/{userID}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowersList(
        @PathVariable Integer userID, @RequestParam(defaultValue = "none") String order){
            return ResponseEntity.ok().body(userService.getFollowers(userID, order));
    }
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed(
        @PathVariable Integer userId, @RequestParam(defaultValue = "none") String order){
            return new ResponseEntity<>(userService.getFollowed(userId, order), HttpStatus.OK);
    }
}
