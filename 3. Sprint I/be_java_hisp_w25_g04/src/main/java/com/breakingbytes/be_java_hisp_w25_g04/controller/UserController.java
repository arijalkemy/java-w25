package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDto;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.ISellerService;
import com.breakingbytes.be_java_hisp_w25_g04.service.IUserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    IUserService userService;
    ISellerService sellerService;
    public UserController(IUserService userService, ISellerService sellerService) {
        this.userService = userService;
        this.sellerService = sellerService;
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable("userId") String userId,
                                          @PathVariable("userIdToUnfollow") String userIdToUnfollow) {
        sellerService.quitFollower(userIdToUnfollow, userId);
        return ResponseEntity.ok()
                .body(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<LastPostsDto> getPostOfVendorsFollowedByUser(
            @PathVariable int userId,
            @RequestParam(name = "order", required = false, defaultValue = "none") String order){
        return ResponseEntity.ok()
                .body(this.userService.getPostOfVendorsFollowedByUser(userId, order));
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(@RequestBody PostDTO postDTO){
        sellerService.addPost(postDTO);
        return ResponseEntity
                .ok().build();
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<?> getCountFollowers(@PathVariable int userId){
        return ResponseEntity.ok()
                .body(userService.getCountFollowersOfSeller(userId));
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> getUsersFollowersOf(@PathVariable int userId, @RequestParam(required = false, defaultValue = "") String order){
        return ResponseEntity.ok()
                .body(userService.getUsersFollowersOf(userId, order));
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> getUsersFollowed(@PathVariable int userId, @RequestParam(required = false, defaultValue = "") String order){
        return ResponseEntity.ok()
                .body(userService.getUsersFollowed(userId, order));
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable("userId") int userId, @PathVariable("userIdToFollow") int userIdToFollow) {
        userService.follow(userId, userIdToFollow);
        return ResponseEntity
                .ok().build();
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok()
                .body(sellerService.findAllPosts());
    }
}
