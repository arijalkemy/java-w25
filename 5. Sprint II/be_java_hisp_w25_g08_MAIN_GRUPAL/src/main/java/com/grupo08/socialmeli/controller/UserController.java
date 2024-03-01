package com.grupo08.socialmeli.controller;

import com.grupo08.socialmeli.service.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    IUserService sellerService;

    public UserController(IUserService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@Positive(message = "El id debe ser mayor a 0.")
                                          @PathVariable int userId,
                                          @Positive(message = "El id debe ser mayor a 0.")
                                          @PathVariable int userIdToFollow){
        return new ResponseEntity<>(sellerService.follow(userId, userIdToFollow), HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowers(@Positive(message = "El id debe ser mayor a 0.")
                                              @PathVariable int userId,
                                          @RequestParam(required = false, defaultValue = "default") String order){
        return new ResponseEntity<>(sellerService.getFollowers(userId,order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToFollow}")
    public ResponseEntity<?> unFollowSeller(@Positive(message = "El id debe ser mayor a 0.")
                                                @PathVariable int userId,
                                            @Positive(message = "El id debe ser mayor a 0.")
                                            @PathVariable int userIdToFollow){
        sellerService.unfollow(userId, userIdToFollow);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedSellers(@Positive(message = "El id debe ser mayor a 0.")
                                                    @PathVariable int userId,
                                                @RequestParam(required = false) String order){
        return new ResponseEntity<>(sellerService.getFollowedSellers(userId, order),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public  ResponseEntity<?> followersCount(@Positive(message = "El id debe ser mayor a 0.")
                                                 @PathVariable int userId){
        return new ResponseEntity<>(sellerService.countSellerFollowers(userId),HttpStatus.OK);
    }

}
