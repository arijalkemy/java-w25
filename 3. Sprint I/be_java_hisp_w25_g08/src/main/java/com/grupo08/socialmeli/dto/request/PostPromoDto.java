package com.grupo08.socialmeli.dto.request;

import com.grupo08.socialmeli.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostPromoDto {
    public int user_id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    public LocalDate date;
    public Product product;
    public int category;
    public double price;
    public boolean has_promo;
    public double discount;
}
