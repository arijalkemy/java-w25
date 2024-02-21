package org.socialmeli.controller;

import org.socialmeli.dto.request.*;
import org.socialmeli.dto.response.*;
import org.socialmeli.service.IPostsService;
import org.socialmeli.service.IUsersService;
import org.socialmeli.service.implementation.PostsServiceImp;
import org.socialmeli.service.implementation.UsersServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UsersController {

    private IPostsService postsService;
    private IUsersService usersService;

    public UsersController(PostsServiceImp postsService, UsersServiceImp usersService) {
        this.postsService = postsService;
        this.usersService = usersService;
    }

    // US_0001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> followUser(@PathVariable Integer userId,
                                       @PathVariable Integer userIdToFollow){
        usersService.userFollowVendor(new UserFollowVendorDto(userId,userIdToFollow));
        return new ResponseEntity<>(new MessageDto("Vendedor seguido exitosamente"),HttpStatus.OK);

    }

    // US_0002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDto> followersCount(@PathVariable Integer userId){
        return  new ResponseEntity<>(usersService.vendorFollowersCount(new UserIdDto(userId)),HttpStatus.OK);
    }

    //US_0003
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<VendorFollowersListDTO> followersList(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "name_desc") String order){

        return new ResponseEntity<>(usersService.getFollowersList(new FollowersListReqDto(userId, order)), HttpStatus.OK);
    }

    //US_0004
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<VendorsFollowingListDto> followingList(
             @PathVariable Integer userId,
             @RequestParam(required = false, defaultValue = "name_desc") String order){

        return ResponseEntity.ok(usersService.getFollowingList(new FollowingListReqDto(userId, order)));
    }

    // US_0006
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedListDto> followedList(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "date_desc") String order){
        return new ResponseEntity<>(postsService.getFollowedList(new FollowedListReqDto(userId, order)), HttpStatus.OK);
    }

    // US_0007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDto> unfollowVendor(@PathVariable Integer userId,
                                                     @PathVariable Integer userIdToUnfollow){
        return new ResponseEntity<>(usersService.unfollowVendor(new UserUnfollowVendorDTO(userId, userIdToUnfollow)), HttpStatus.OK);
    }
}
