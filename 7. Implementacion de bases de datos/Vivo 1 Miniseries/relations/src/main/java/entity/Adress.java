package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "address")
    User user;
}
