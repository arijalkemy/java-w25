package com.bootcamp.be_java_hisp_w25_g02.controller;
import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.service.IPostService;
import com.bootcamp.be_java_hisp_w25_g02.service.PostServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class ProductController {

    private IPostService postService;

    public ProductController(PostServiceImpl postService){
        this.postService = postService;
    }
  
    @PostMapping("/products/post")
    public ResponseEntity<?> savePost(@RequestBody @Valid PostDTO post) {
        return new ResponseEntity<>(this.postService.savePost(post), HttpStatus.OK);
    }

    @GetMapping("products/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPosts(@PathVariable @Positive(message = "El Id de usuario debe ser un numero positivo") @NotNull(message = "El id del usuario no puede ser null") Integer userId, @RequestParam( required = false) String order){
        return new ResponseEntity<>(this.postService.getPostsOrderedByDate(userId, order), HttpStatus.OK);
    }
}
