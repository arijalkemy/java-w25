package com.example.relationships.service.impl;

import com.example.relationships.dto.CreateCartRequestDto;
import com.example.relationships.model.Cart;
import com.example.relationships.repository.CartRepository;
import com.example.relationships.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CartRepository repository;
    private final ModelMapper mapper;
    @Override
    public Cart createCart(CreateCartRequestDto newCartDto){
        Cart newCart = mapper.map(newCartDto, Cart.class);
        newCart.getItems().forEach(item -> item.setCart(newCart));
        return repository.save(newCart);
    }

    @Override
    public List<Cart> getAllCarts(){
        return repository.findAll();
    }
    @Override
    public void deleteCart(Long id){
         repository.deleteById(id);
    }
}
