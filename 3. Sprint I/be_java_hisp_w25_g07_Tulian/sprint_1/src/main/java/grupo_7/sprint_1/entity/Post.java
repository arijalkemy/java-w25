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
    boolean has_promo;
    Double discount;
    LocalDate date;
}
