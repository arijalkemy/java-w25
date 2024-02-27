package org.bootcamp.javazoo.helper;

import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.ProductDto;
import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.dto.response.CountPromoDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.dto.response.PromoPostListDto;
import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Mapper {
    public static UserDto convertUserToUserDto(User user) {
        return new UserDto(user.getId(), user.getName());
    }

    public static Post convertDtoToPost(PostDto postDto, Integer postId){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (postDto.getHas_promo() != null && postDto.getHas_promo()) {
            return new Post(
                    postId,
                    LocalDate.parse(postDto.getDate(), formatter),
                    convertDtoToProduct(postDto.getProduct()),
                    postDto.getCategory(),
                    postDto.getPrice(),
                    postDto.getHas_promo(),
                    postDto.getDiscount()
            );
        } else {
            return new Post(
                    postId,
                    LocalDate.parse(postDto.getDate(), formatter),
                    convertDtoToProduct(postDto.getProduct()),
                    postDto.getCategory(),
                    postDto.getPrice(),
                    false,
                    0.0
            );
        }
    }
    public static Product convertDtoToProduct(ProductDto productDto) {
        return new Product(
                productDto.getProduct_id(),
                productDto.getProduct_name(),
                productDto.getType(),
                productDto.getBrand(),
                productDto.getColor(),
                productDto.getNotes()
        );
    }
    public static PostResponseDto mapToPostDto(Post postToMap, Integer sellerId){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return new PostResponseDto(
                sellerId,
                postToMap.getId(),
                postToMap.getDate().format(formatter),
                mapToProductDto(postToMap.getProduct()),
                postToMap.getCategory(),
                postToMap.getPrice(),
                postToMap.getHasPromo(),
                postToMap.getDiscount()
        );
    }
    public static PostsFollowedUserDto mapToPostsFollowedUserDto(List<PostResponseDto> postDtos, int userId){
        return new PostsFollowedUserDto(userId, postDtos);
    }
    public static ProductDto mapToProductDto(Product productToMap) {
        return new ProductDto(
                productToMap.getId(),
                productToMap.getName(),
                productToMap.getType(),
                productToMap.getBrand(),
                productToMap.getColor(),
                productToMap.getNotes());
    }
    public static CountPromoDto mapToCountPromoDto(Seller seller, Integer count) {
        return new CountPromoDto(seller.getId(), seller.getName(), count);
    }
    public static PromoPostListDto mapToPromoPostListDto(List<PostResponseDto> postDtos, Seller seller){
        return new PromoPostListDto(seller.getId(), seller.getName(), postDtos);
    }

}
