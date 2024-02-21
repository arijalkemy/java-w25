package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dtos.*;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.service.ISellerService;
import grupo_7.sprint_1.service.SellerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    ISellerService sellerService;

    public SellerController(SellerServiceImp sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> postPost(@RequestBody PostPostDto newPost) {
        return new ResponseEntity<>(sellerService.postPost(newPost.userId(), newPost), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowersListDto> getFollowersList(@PathVariable Integer userId, boolean orderAsc) {

        return ResponseEntity.ok(sellerService.getListOrderedAlphabetically(userId, orderAsc));
    }

    @GetMapping("/users/allsellers")
    public ResponseEntity<?> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAllSellers());
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<SellerDTO> getFollowersCount(@PathVariable int userId) {
            SellerDTO sellerDTO = sellerService.cantidadSeguidores(userId);
            return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<List<PostDto>> getRecentPostsFromFollowedSellers(@PathVariable Integer userId, @RequestParam String order ) {
        List<PostDto> posts = sellerService.getRecentPostsFromFollowedSellers(userId,order);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @PostMapping("/products/promo-post")
    public ResponseEntity<PostDto> postPromoPost(@RequestBody AddPromoPostDto newPromoPost) {
        PostDto postDto = sellerService.postPromoPost(newPromoPost);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<SellerDTO> getPromoCount(@RequestParam("user_id") int userId) {
            SellerDTO sellerDTO = sellerService.cantidadPromoPost(userId);
            return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<List<PostDto>> getPromoPost(@RequestParam("user_id") int userId) {
        List<PostDto> postList = sellerService.getPromoPostsBySeller(userId);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }
}
