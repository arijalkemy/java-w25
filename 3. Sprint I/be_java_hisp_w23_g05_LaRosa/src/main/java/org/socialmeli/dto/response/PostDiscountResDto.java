package org.socialmeli.dto.response;

import java.time.LocalDate;

import org.socialmeli.entity.PostDiscount;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDiscountResDto {
    Integer user_id;
    Integer post_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    ProductDto product;
    Integer category;
    Double price;
    Boolean has_promo;
    private Double discount;

    public PostDiscountResDto(Integer post_id, Integer user_id, LocalDate date, ProductDto product, Integer category,
            Double price, Boolean has_promo, Double discount) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public PostDiscountResDto(PostDiscount postDiscount) {
        this.post_id = postDiscount.getPostId();
        this.user_id = postDiscount.getUserId();
        this.date = postDiscount.getDate();
        this.product = new ProductDto(postDiscount.getProduct().getProductId(),
                postDiscount.getProduct().getProductName(), postDiscount.getProduct().getType(),
                postDiscount.getProduct().getBrand(), postDiscount.getProduct().getColor(),
                postDiscount.getProduct().getNotes());
        this.category = postDiscount.getCategory();
        this.price = postDiscount.getPrice();
        this.has_promo = postDiscount.getHasPromo();
        this.discount = postDiscount.getDiscount();
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getHas_promo() {
        return has_promo;
    }

    public void setHas_promo(Boolean has_promo) {
        this.has_promo = has_promo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}
