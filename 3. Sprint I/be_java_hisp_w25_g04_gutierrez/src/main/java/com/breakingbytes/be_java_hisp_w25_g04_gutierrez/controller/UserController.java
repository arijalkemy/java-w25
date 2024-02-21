package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.controller;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.service.ISellerService;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    IUserService userService;
    ISellerService sellerService;
    public UserController(IUserService userService, ISellerService sellerService) {
        this.userService = userService;
        this.sellerService = sellerService;
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable("userId") String userId,
                                          @PathVariable("userIdToUnfollow") String userIdToUnfollow) {
        sellerService.quitFollower(userIdToUnfollow, userId);
        return ResponseEntity.ok()
                .body(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getCountFollowers(@PathVariable int userId){
        return ResponseEntity.ok()
                .body(sellerService.getCountFollowersOfSeller(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getUsersFollowersOf(@PathVariable int userId, @RequestParam(required = false, defaultValue = "") String order){
        return ResponseEntity.ok()
                .body(userService.getUsersFollowersOf(userId, order));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getUsersFollowed(@PathVariable int userId, @RequestParam(required = false, defaultValue = "") String order){
        return ResponseEntity.ok()
                .body(userService.getUsersFollowed(userId, order));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable("userId") int userId, @PathVariable("userIdToFollow") int userIdToFollow) {
        userService.follow(userId, userIdToFollow);
        return ResponseEntity
                .ok().build();
    }

}
