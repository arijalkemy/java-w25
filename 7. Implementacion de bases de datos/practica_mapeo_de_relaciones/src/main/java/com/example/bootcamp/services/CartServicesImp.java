package com.example.bootcamp.services;

import com.example.bootcamp.dto.CartDTO;
import com.example.bootcamp.model.Cart;
import com.example.bootcamp.model.Item;
import com.example.bootcamp.repositories.ICartRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServicesImp {
    private ICartRepository cartRepository;

    public CartServicesImp(ICartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public List<CartDTO> findAll(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(cartRepository.findAll(), new TypeReference<List<CartDTO>>() {});
    }

    public CartDTO create(CartDTO cartDTO){
        ModelMapper mapper = new ModelMapper();
        final Cart cart = mapper.map(cartDTO, Cart.class);
        System.out.println(cart.getItems());
        cart.getItems().forEach(i -> i.setCart(cart));
        Cart cart2 = cartRepository.save(cart);
        return mapper.map(cart2, CartDTO.class);
    }

    public void delete(Long id){
        cartRepository.deleteById(id);
    }

    /*public CartDTO update(CartDTO cartDTO){

        return mapper.map(cart, CartDTO.class);
    }*/
}
