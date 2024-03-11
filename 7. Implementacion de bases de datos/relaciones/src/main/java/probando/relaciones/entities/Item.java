package probando.relaciones.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
