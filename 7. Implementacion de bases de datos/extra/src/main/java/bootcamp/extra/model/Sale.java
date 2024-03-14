package bootcamp.extra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Table(name = "sales")
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sale {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonFormat(pattern="dd/MM/yyyy")
    LocalDate date;
    Double total;
    String paymentMethod;

    @ManyToMany
    @JoinTable(
            name= "sale_cloth",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "cloth_id")
    )
    List<Cloth> clothsList;
}
