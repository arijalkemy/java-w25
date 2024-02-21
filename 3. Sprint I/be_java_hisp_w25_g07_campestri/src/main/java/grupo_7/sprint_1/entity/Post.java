package grupo_7.sprint_1.entity;

import lombok.*;

import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Post {
    Product product;
    Integer category;
    Double price;
    LocalDate date;
    Boolean has_promo;
    Double discount;

    public Post(Product product, Integer category, Double price, LocalDate date) {
        this.product = product;
        this.category = category;
        this.price = price;
        this.date = date;
    }
}
