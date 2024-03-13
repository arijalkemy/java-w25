package bootcamp.miniseries.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Double rating;

    @Column(name = "amount_of_awards")
    int amountOfAwards;

}
