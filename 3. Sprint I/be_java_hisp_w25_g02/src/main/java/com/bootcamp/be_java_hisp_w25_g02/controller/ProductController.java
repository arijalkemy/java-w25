package com.bootcamp.be_java_hisp_w25_g02.controller;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.service.IPostService;
import com.bootcamp.be_java_hisp_w25_g02.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final IPostService postService;
    public ProductController(PostServiceImpl postService){
        this.postService = postService;
    }
  
    @PostMapping("products/post")
    public ResponseEntity<?> savePost(@RequestBody PostDTO post) {
        return new ResponseEntity<>(this.postService.savePost(post), HttpStatus.OK);
    }

    @GetMapping("products/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPosts(@PathVariable Integer userId, @RequestParam(defaultValue = "date_asc", required = false) String order){
        return new ResponseEntity<>(this.postService.getPostsOrderedByDate(userId, order), HttpStatus.OK);
    }
}
