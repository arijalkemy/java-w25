package com.mercadolibre.be_java_hisp_w25_g15.controller;

import com.mercadolibre.be_java_hisp_w25_g15.dto.request.UnfollowDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountFollowersDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserListDto;
import com.mercadolibre.be_java_hisp_w25_g15.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageResponseDto> followUser(
            @PathVariable int userId,
            @PathVariable int userIdToFollow
    ) {
        return new ResponseEntity<>(
                this.userService.followSeller(userId, userIdToFollow),
                HttpStatus.OK
        );
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CountFollowersDto> countFollowers(
            @PathVariable int userId
    ) {
        return new ResponseEntity<>(
                this.userService.countFollowersByUserId(userId),
                HttpStatus.OK
        );
    }


    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageResponseDto> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        UnfollowDto unfollowDto = new UnfollowDto(userId, userIdToUnfollow);
        return new ResponseEntity<>(userService.unfollowSeller(unfollowDto), HttpStatus.OK);
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<UserListDto>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDto> getAllFollowedByUser(@PathVariable int userId, @RequestParam(name = "order", required = false) String order) {
        return new ResponseEntity<>(userService.findAllFollowedByUser(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDto> getAllFollowersByUser(@PathVariable int userId, @RequestParam(name = "order", required = false) String order) {
        return new ResponseEntity<>(userService.findAllSellerFollowers(userId, order), HttpStatus.OK);
    }
}
