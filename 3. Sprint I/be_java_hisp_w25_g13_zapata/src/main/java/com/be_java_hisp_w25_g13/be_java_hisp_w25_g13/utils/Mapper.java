package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Promo;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static ProductDTO mapProductToProductDTO(Product product){
        return new ProductDTO(product.getProductId(),product.getProductName(), product.getType(),product.getBrand(),product.getColor(), product.getNotes());
    }
    public static PostResponseDTO mapPostToPost2DTO(Post post){
        return new PostResponseDTO(post.getUserId(), post.getPostId(), post.getDate(),mapProductToProductDTO(post.getProduct()), post.getCategory(), post.getPrice());
    }

    public static UserDTO mapUserToUserDto(User user) {

        return new UserDTO(user.getUserId(), user.getUserName());
    }

    public static Product mapProductDtoToProduct(ProductDTO productDTO){
        return new Product(productDTO.getProductId(), productDTO.getProductName(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());
    }

    public static Post mapPostDtoToPost(PostDTO postDTO){
        return new Post(postDTO.getUserId(), postDTO.getDate(), mapProductDtoToProduct(postDTO.getProduct()), postDTO.getCategory(), postDTO.getPrice());
    }
    public static ProductDTO mapProductToProductDto(Product product){
        return new ProductDTO(product.getProductId(), product.getBrand(), product.getType(), product.getProductName(), product.getColor(), product.getNotes());
    }
  
    public static FollowersDTO toFollowersDTO(User user, List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User userAux :
                users) {
            userDTOS.add(Mapper.mapUserToUserDto(userAux));
        }
        return new FollowersDTO(user.getUserId(), user.getUserName(), userDTOS);
    }
    public static PromoDTO mapPromoToPromoDTO(Promo promo){
        return new PromoDTO(promo.getUserId(), promo.getDate(), mapProductToProductDTO(promo.getProduct()), promo.getCategory(),promo.getPrice(), promo.getHasPromo(), promo.getDiscount());
    }
    public static Promo mapPromoDTOToPromo(PromoDTO promoDTO){
        return new Promo(promoDTO.getUserId(), promoDTO.getDate(), mapProductDtoToProduct(promoDTO.getProduct()), promoDTO.getCategory(), promoDTO.getPrice(), promoDTO.getHasPromo(), promoDTO.getDiscount());
    }
}
