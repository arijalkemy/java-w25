package org.socialmeli.entity;

import java.time.LocalDate;

public class PostDiscount extends Post {
    private Boolean hasPromo;
    private Double discount;

    public PostDiscount(Integer userId, LocalDate date, Product product, Integer category, Double price,
            Boolean hasPromo, Double discount) {
        super(userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "PostDiscount [postId=" + postId + ", userId=" + userId + ", date=" + date + ", product=" + product
                + ", category=" + category + ", price=" + price + ", hasPromo=" + hasPromo + ", discount=" + discount
                + "]";
    }

}
