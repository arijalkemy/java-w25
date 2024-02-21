package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.controller;


import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoCountDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostListResponseDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.SellerPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.IPostService;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ProductDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")

public class PostController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    IPostService postService;

    @GetMapping("followed/{userId}/list")
    public ResponseEntity<SellerPostDTO> getPostPerSeller(
        @PathVariable Integer userId, @RequestParam(defaultValue = "none") String order){
            return new ResponseEntity<>(postService.getPostPerSeller(userId, order), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.addPost(postDTO), HttpStatus.OK);
    }
    @PostMapping("/promo-post")
    public ResponseEntity<PromoPostDTO> createPromoPost(@RequestBody PromoPostDTO promoPostDTO){
        return new ResponseEntity<>(postService.addPromoPost(promoPostDTO), HttpStatus.CREATED);
    }
    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> listProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoCountDTO> getPromoCount(@RequestParam Integer userId){
        return new ResponseEntity<>(postService.getPromoProductsCount(userId),HttpStatus.OK);
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListResponseDTO> getPromoList(@RequestParam Integer userId, @RequestParam(defaultValue = "none") String order){
        return new ResponseEntity<>(postService.getPromoPostsList(userId, order),HttpStatus.OK);
    }
}
