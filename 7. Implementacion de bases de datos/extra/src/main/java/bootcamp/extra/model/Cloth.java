package bootcamp.extra.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(name = "prendas")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String code;

    String name;

    String type;

    String brand;

    String color;

    String size;

    Integer amount;

    @Column(name = "sale_price")
    Double salePrice;

}
