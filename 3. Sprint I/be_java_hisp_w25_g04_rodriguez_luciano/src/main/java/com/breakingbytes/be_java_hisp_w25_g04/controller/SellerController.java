package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.ISellerService;
import com.breakingbytes.be_java_hisp_w25_g04.service.SellerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerController {

    ISellerService sellerService;

    public SellerController(SellerServiceImpl sellerService){
        this.sellerService = sellerService;
    }

    // Ejercicio 0002
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<?> getCountFollowers(@PathVariable int userId){
        return ResponseEntity.ok().body(sellerService.getCountFollowersOfSeller(userId));
    }

    // Ejercicio 003, 005
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> getUsersFollowersOf(@PathVariable int userId, @RequestParam(required = false, defaultValue = "") String order){
        return ResponseEntity.ok().body(sellerService.getUsersFollowersOf(userId, order));
    }

    // Ejercicio Bonus
    @PostMapping("/users/{userId}/create/seller")
    public ResponseEntity<?> getUsersFollowersOf(@PathVariable int userId){
        sellerService.makeSeller(userId);
        return ResponseEntity.ok().build();
    }
}
