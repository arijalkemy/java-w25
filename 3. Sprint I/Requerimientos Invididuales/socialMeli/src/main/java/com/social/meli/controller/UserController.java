package com.social.meli.controller;

import com.social.meli.dto.response.FollowedListDto;
import com.social.meli.dto.response.MessageDTO;
import com.social.meli.dto.response.UserUnfollowedDto;
import com.social.meli.dto.response.VendorFollowCountDto;
import com.social.meli.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class UserController {
    private final IUserService userService;


    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowedListDto> getVendorFollowers(@PathVariable Integer userId,
                                                                    @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getVendorFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<VendorFollowCountDto> getFollowerCount(@PathVariable Integer userId) {
        return ResponseEntity.ok().body(userService.getFollowerCount(userId));
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedListDto> getFollowedList(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(userService.getFollowedList(userId, order));
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDTO> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return new ResponseEntity<>(userService.newFollow(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDTO> unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        return ResponseEntity.ok().body(userService.unfollowUser(userId, userIdToUnfollow));
    }
}
