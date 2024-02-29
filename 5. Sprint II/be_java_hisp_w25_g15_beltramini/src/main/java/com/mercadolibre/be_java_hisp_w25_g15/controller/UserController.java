package com.mercadolibre.be_java_hisp_w25_g15.controller;

import com.mercadolibre.be_java_hisp_w25_g15.dto.request.FollowDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.UnfollowDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountFollowersDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserListDto;
import com.mercadolibre.be_java_hisp_w25_g15.service.IUserService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageResponseDto> followUser(
            @PathVariable
            @NotNull(message = "The user id cannot be null")
            @Positive(message = "The user id must be a positive integer")
            Integer userId,
            @PathVariable
            @NotNull(message = "The user id to follow cannot be null")
            @Positive(message = "The user id to follow must be a positive integer")
            Integer userIdToFollow
            ) {
        return new ResponseEntity<>(
                this.userService.followSeller(new FollowDto(userId, userIdToFollow)),
                HttpStatus.OK
        );
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CountFollowersDto> countFollowers(
            @PathVariable Integer userId
    ) {
        return new ResponseEntity<>(
                this.userService.countFollowersByUserId(userId),
                HttpStatus.OK
        );
    }


    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageResponseDto> unfollowUser(
            @PathVariable
            @NotNull(message = "The user id cannot be null")
            @Positive(message = "The user id must be a positive integer")
            Integer userId,
            @PathVariable
            @NotNull(message = "The user id to follow cannot be null")
            @Positive(message = "The user id to unfollow must be a positive integer")
            Integer userIdToUnfollow
    ){
        return new ResponseEntity<>(userService.unfollowSeller(new UnfollowDto(userId, userIdToUnfollow)), HttpStatus.OK);
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<UserListDto>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDto> getAllFollowedByUser(@PathVariable Integer userId, @RequestParam(name = "order", required = false) String order) {
        return new ResponseEntity<>(userService.findAllFollowedByUser(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDto> getAllFollowersByUser(@PathVariable Integer userId, @RequestParam(name = "order", required = false) String order) {
        return new ResponseEntity<>(userService.findAllSellerFollowers(userId, order), HttpStatus.OK);
    }
}
