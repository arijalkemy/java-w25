package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.FollowedDTO;
import com.example.bootcampsprint1g6.dto.FollowersCountDTO;
import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import com.example.bootcampsprint1g6.service.IUserService;
import com.example.bootcampsprint1g6.service.implementation.UserServiceImpl;
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

    /**
     * Endpoint to follow a seller
     * @param userId The user who wants to follow a seller
     * @param userIdToFollow User to be followed
     * @return Confirmation of following
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<GenericResponseDTO> follow(
        @PathVariable Integer userId,
        @PathVariable Integer userIdToFollow
    ) {
        return ResponseEntity.ok(userService.follow(userId, userIdToFollow));
    }

    /**
     * Endpoint to unfollow an user
     * @param userId User who wants to unfollow a seller
     * @param userIdToFollow User to be unfollowed
     * @return Confirmation of unfollowing
     */
    @PostMapping("/{userId}/unfollow/{userIdToFollow}")
    public ResponseEntity<GenericResponseDTO> unfollow(
        @PathVariable Integer userId,
        @PathVariable Integer userIdToFollow
    ) {
        return ResponseEntity.ok(userService.unfollow(userId, userIdToFollow));
    }


    /**
     * Get followed list from an user
     * @param userId User to get their followed list
     * @param order Optional parameter to order the return list. Could be "name_asc" or "name_desc"
     * @return ResponseEntity with the Followed list
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowedList(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ){
        return ResponseEntity.ok(userService.getFollowedList(userId, order));
    }

    /**
     * Get quantity of followers from an user
     * @param userId user to get followers quantity
     * @return ResponseEntity with quantity of followers
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(
            @PathVariable Integer userId
    ) {
        return new ResponseEntity<>(userService.getFollowersCount(userId),HttpStatus.OK);
    }

    /**
     * Get followers list from an user
     * @param userId User to get their followers list
     * @param order Optional parameter to order the return list. Could be "name_asc" or "name_desc"
     * @return ResponseEntity with the Followers list
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ){
        return ResponseEntity.ok(userService.getFollowersList(userId, order));
    }
}

