package com.example.relationships.controller;

import com.example.relationships.dto.CreateCartRequestDto;
import com.example.relationships.model.Cart;
import com.example.relationships.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final ICartService cartService;

    @GetMapping("/")
    public ResponseEntity<List<Cart>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }
    @PostMapping("/")
    public ResponseEntity<Cart> createCart(@RequestBody CreateCartRequestDto newCart){
        return ResponseEntity.ok(cartService.createCart(newCart));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
        return ResponseEntity.ok(null);
    }
}
