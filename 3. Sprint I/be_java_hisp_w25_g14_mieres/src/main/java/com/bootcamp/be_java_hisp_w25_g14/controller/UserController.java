package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import com.bootcamp.be_java_hisp_w25_g14.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @GetMapping("/{id}/followers/list")
    public ResponseEntity<?> listSellersFollower(@PathVariable int id,
                                                  @RequestParam(required = false) String order){


        return new ResponseEntity<>(this.userService.listSellersFollowers(id, order), HttpStatus.OK);
    }

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> addFollow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        this.userService.addFollowe(userId,userIdToFollow);
        return new ResponseEntity<>(new MessageDto("Follow successfully",""), HttpStatus.OK);
    }

    @GetMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> removeFollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        this.userService.removeFollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(new MessageDto("Unfollow successfully", ""), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?>getFollowed(@PathVariable Integer userId){
        return new ResponseEntity<>(this.userService.getFollowedByUser(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getUserFollowersCount(@PathVariable Integer userId) {
        return new ResponseEntity<>(this.userService.getUserFollowersCount(userId),HttpStatus.OK);
    }

    /*
        Trabajo individual - US0012
        -Obtener el promedio de precios de un vendedor

        METHOD: GET
        PATH VARIABLE: Int UserID
        RETURN: {int userId, String userName, int numberOfPosts, Double avgPrice}
        RESPONSE: 200
     */
    @GetMapping("/{userId}/price/avg")
    public ResponseEntity<?> getAvgPriceById(@PathVariable Integer userId){
        return new ResponseEntity<>(this.userService.getAvgPriceById(userId),HttpStatus.OK);
    }

}
