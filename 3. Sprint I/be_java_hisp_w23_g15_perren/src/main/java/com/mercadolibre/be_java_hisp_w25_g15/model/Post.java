package com.mercadolibre.be_java_hisp_w25_g15.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    static final AtomicInteger idGenerator = new AtomicInteger();
    @JsonProperty("post_id")
    int id;
    @JsonProperty("user_id")
    int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate date;
    Product product;
    int category;
    double price;
    @JsonProperty("has_promo")
    Boolean hasPromo = false;
    Double discount;


    public Post(int user, LocalDate date, Product product, int category, double price) {
        this.id = idGenerator.incrementAndGet();
        this.userId = user;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;

    }

    public Post(int userId, LocalDate date, Product product, int category, double price, Boolean hasPromo, Double discount) {
        this.id = idGenerator.incrementAndGet();
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = Boolean.TRUE.equals(hasPromo);
        this.discount = discount;
    }

    public void setHasPromo(Boolean hasPromo) {
        if (hasPromo != null) {
            this.hasPromo = hasPromo;
        }
    }

    public void setDiscount(Double discount) {
        if (discount != null) {
            this.discount = discount;
        }else{
            this.discount = 0.0;
        }
    }
}
