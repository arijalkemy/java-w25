package com.example.relationships.service;

import com.example.relationships.dto.CreateCartRequestDto;
import com.example.relationships.model.Cart;

import java.util.List;

public interface ICartService {
        Cart createCart(CreateCartRequestDto newCart);
        List<Cart> getAllCarts();

    void deleteCart(Long id);
}
